package com.xwd.xwd_uoms.common.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.xwd.xwd_uoms.common.exception.LoginException;
import com.xwd.xwd_uoms.config.jwtconfig.JwtConfig;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {
    @Resource
    private JwtConfig jwtConfig;

    private Key getSigningKey() {
        String secret = jwtConfig.getSecret();
        Assert.notBlank(secret, "JWT密钥不可为空.");
        Assert.isTrue(secret.getBytes(StandardCharsets.UTF_8).length >= 32,
                "JWT密钥长度至少为32字节.");
        byte[] secretByte = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(secretByte);
    }

    private String generateJwtToken(Map<String,Object> claims,Long expiretion){
        Date now = DateUtil.date();
        Date expiretionDate = DateUtil.offsetMillisecond(now,expiretion.intValue());
        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiretionDate)
                .signWith(getSigningKey(),SignatureAlgorithm.HS256)
                .compact();

        return token;
    }

    public String generateAccessToken(Map<String, Object> claims) {
        Assert.notNull(claims, "JWT载荷数据不可为空.");
        return generateJwtToken(claims, jwtConfig.getAccessExpiration());
    }

    public String generateRefreshToken(Map<String, Object> claims) {
        Assert.notNull(claims, "JWT载荷数据不可为空.");
        return generateJwtToken(claims, jwtConfig.getRefreshExpiration());
    }

    private Jws<Claims> parseAndValidateToken(String token) {
        if (StrUtil.isBlank(token)) {
            throw new IllegalArgumentException("令牌不可为空.");
        }
        try {
            return  Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);

        } catch (ExpiredJwtException e) {
            throw new LoginException("令牌已过期.");
        } catch (UnsupportedJwtException e) {
            throw new IllegalArgumentException("令牌格式错误.");
        } catch (SignatureException e) {
            throw new IllegalArgumentException("令牌签名错误.");
        } catch (IllegalArgumentException | MalformedJwtException e) {
            throw new IllegalArgumentException("令牌格式非法.");
        } catch (Exception e) {
            throw new RuntimeException("未知错误-" + e.getMessage(), e);
        }
    }

    public void validateToken(String token) {
        if (token != null) {
            token = token.trim().replaceAll("^[\"']|[\"']$", "");
        }
        if (StrUtil.isBlank(token)) {
            throw new IllegalArgumentException("令牌不可为空.");
        }
        parseAndValidateToken(token);
    }

    public Claims parseToken(String token) {
        return parseAndValidateToken(token).getBody();
    }

    public String getFromToken(String token, String key) {
        Claims claims = parseToken(token);
        Object value = claims.get(key);
        if (value == null) {
            throw new IllegalArgumentException("JWT令牌中未包含指定key: " + key);
        }
        return value.toString();
    }
}