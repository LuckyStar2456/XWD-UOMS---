package com.xwd.xwd_uoms.service.auth.impl;

import com.xwd.xwd_uoms.common.util.JwtUtil;
import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.config.jwtconfig.JwtConfig;
import com.xwd.xwd_uoms.service.auth.TokenService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class TokenServiceImpl implements TokenService {
    @Resource
    private JwtUtil jwtUtil;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Resource
    private JwtConfig jwtConfig;

    @Resource
    private VerifyUtil verifyUtil;

    @Override
    public void verifyRefreshToken(String refreshToken) throws Exception {
        try {
            jwtUtil.validateToken(refreshToken);
            String username = jwtUtil.getFromToken(refreshToken,"username");
            String redisKey = "refresh_token:" + username;

            String redisRefreshToken = redisTemplate.opsForValue().get(redisKey);
            if (!verifyUtil.isExist(redisRefreshToken)) {
                throw new IllegalArgumentException("Token不存在，请重新登录.");
            }
            if (!Objects.equals(redisRefreshToken,refreshToken)) {
                throw new IllegalArgumentException("Token无效，请重新登录.");
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (Exception e) {
            throw new Exception("Token校验失败：" + e.getMessage());
        }
    }

    @Override
    public Map<String,String> generateTokens(Map<String, Object> claims, String key) throws Exception {
        String refreshToken = jwtUtil.generateRefreshToken(claims);
        String accessToken = jwtUtil.generateAccessToken(claims);

        try {
            String redisKey = "refresh_token:" + key;
            redisTemplate.opsForValue().set(
                    redisKey,
                    refreshToken,
                    jwtConfig.getRefreshExpiration(),
                    TimeUnit.MILLISECONDS
            );

            redisKey = "access_token:" + key;
            redisTemplate.opsForValue().set(
                    redisKey,
                    accessToken,
                    jwtConfig.getAccessExpiration(),
                    TimeUnit.MILLISECONDS
            );

        }catch (RuntimeException e){
            throw new RuntimeException("Redis服务异常.");
        }

        Map<String,String> tokens = new HashMap<>();
        tokens.put("refreshToken",refreshToken);
        tokens.put("accessToken",accessToken);
        return tokens;
    }

    @Override
    public void deleteToken(String refreshToken) throws Exception {
        String username = jwtUtil.getFromToken(refreshToken,"username");
        
        String refreshTokenKey = "refresh_token:" + username;
        String accessTokenKey = "access_token:" + username;
        
        redisTemplate.delete(refreshTokenKey);
        redisTemplate.delete(accessTokenKey);
    }

    @Override
    public String refreshToken(String refreshToken) throws Exception {
        verifyRefreshToken(refreshToken);

        Map<String, Object> claims = jwtUtil.parseToken(refreshToken);
        String accessToken = jwtUtil.generateAccessToken(claims);

        String username = jwtUtil.getFromToken(refreshToken,"username");

        try {
            String redisKey = "access_token:" + username;
            redisTemplate.delete(redisKey);

            redisTemplate.opsForValue().set(
                    redisKey,
                    accessToken,
                    jwtConfig.getAccessExpiration(),
                    TimeUnit.MILLISECONDS
            );
        }catch (RuntimeException e){
            throw new RuntimeException("Redis服务异常.");
        }

        return accessToken;
    }
}