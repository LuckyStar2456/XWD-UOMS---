package com.xwd.xwd_uoms.service.auth;

import com.xwd.xwd_uoms.entity.dto.LoginDTO;

import java.util.Map;

public interface LoginService {
    void verifyUserLogin(LoginDTO loginDTO) throws Exception;

    Map<String,Object> generateDatas(LoginDTO loginDTO) throws Exception;

    void logout(String refreshToken) throws Exception;
}
