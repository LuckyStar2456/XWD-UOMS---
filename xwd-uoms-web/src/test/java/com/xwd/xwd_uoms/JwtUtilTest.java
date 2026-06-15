package com.xwd.xwd_uoms;

import cn.hutool.core.map.MapUtil;
import com.xwd.xwd_uoms.common.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class JwtUtilTest {
    @Resource
    private JwtUtil jwtUtil;

    private final Map<String, Object> testClaims = MapUtil.<String, Object>builder()
            .put("userId", 1001L)
            .put("username", "testUser")
            .put("role", "admin")
            .build();

    @Test
    public void testV(){
        String reToken = jwtUtil.generateRefreshToken(testClaims);
        String acToken = jwtUtil.generateAccessToken(testClaims);

        jwtUtil.validateToken(acToken);
        jwtUtil.validateToken(reToken);

        Claims jjwt = jwtUtil.parseToken(acToken);
        System.out.println(jjwt);
    }

}