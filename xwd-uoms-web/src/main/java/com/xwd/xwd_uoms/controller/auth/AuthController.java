package com.xwd.xwd_uoms.controller.auth;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.dto.LoginDTO;
import com.xwd.xwd_uoms.entity.dto.RefreshTokenDTO;
import com.xwd.xwd_uoms.service.auth.LoginService;
import com.xwd.xwd_uoms.service.auth.TokenService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Log(module = "auth")
@RestController
@RequestMapping("/xwd_uoms/api/auth")
public class AuthController {
    @Resource
    private LoginService loginService;
    @Resource
    private TokenService tokenService;

    @PostMapping("/login")
    public Result<?> login(@RequestBody LoginDTO loginDTO) throws Exception {
        loginService.verifyUserLogin(loginDTO);
        Map<String,Object> datas = loginService.generateDatas(loginDTO);
        return Result.success(datas);
    }

    @PostMapping("/refreshToken")
    public Result<?> refreshToken(@RequestBody RefreshTokenDTO refreshTokenDTO) throws Exception {
        String accessToken = tokenService.refreshToken(refreshTokenDTO.getRefreshToken());
        return Result.success(accessToken);
    }

    @PostMapping("/logout")
    public Result<?> logout(@RequestBody RefreshTokenDTO refreshTokenDTO) throws Exception {
        loginService.logout(refreshTokenDTO.getRefreshToken());
        return Result.success("登出成功.");
    }
}