package com.xwd.xwd_uoms.service.auth;

import java.util.Map;

public interface TokenService {
    void verifyRefreshToken(String refreshToken) throws Exception;

    Map<String,String> generateTokens(Map<String, Object> claims, String Key) throws Exception;

    void deleteToken(String refreshToken) throws Exception;

    String refreshToken(String refreshToken) throws Exception;
}
