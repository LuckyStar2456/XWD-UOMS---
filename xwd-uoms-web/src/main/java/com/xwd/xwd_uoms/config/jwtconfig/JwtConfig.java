package com.xwd.xwd_uoms.config.jwtconfig;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class JwtConfig {
    @Value("${sys.jwt.secret}")
    private String secret;

    @Value("${sys.jwt.token.expiration.access}")
    private Long accessExpiration;

    @Value("${sys.jwt.token.expiration.refresh}")
    private Long refreshExpiration;
}
