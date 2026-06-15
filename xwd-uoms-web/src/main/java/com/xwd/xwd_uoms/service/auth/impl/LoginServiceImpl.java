package com.xwd.xwd_uoms.service.auth.impl;

import com.xwd.xwd_uoms.common.util.ConvertUtil;
import com.xwd.xwd_uoms.common.util.PasswordEncryptUtil;
import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.entity.SysUserEntity;
import com.xwd.xwd_uoms.entity.dto.LoginDTO;
import com.xwd.xwd_uoms.repository.SysUserRepository;
import com.xwd.xwd_uoms.service.auth.LoginService;
import com.xwd.xwd_uoms.service.auth.TokenService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private PasswordEncryptUtil passwordEncryptUtil;

    @Resource
    private TokenService tokenService;

    @Resource
    private VerifyUtil verifyUtil;

    @Resource
    private ConvertUtil convertUtil;

    @Override
    public void verifyUserLogin(LoginDTO loginDTO) throws Exception {
        SysUserEntity sysUser = sysUserRepository.findByUsername(loginDTO.getUsername());

        if (!verifyUtil.isExist(sysUser)) {
            throw new LoginException("找不到用户.");
        }

        if (!passwordEncryptUtil.matchPassword(loginDTO.getPassword(), sysUser.getPassword())) {

            throw new LoginException("密码错误.");
        }
    }

    @Override
    public Map<String,Object> generateDatas(LoginDTO loginDTO) throws Exception {
        SysUserEntity sysUser = sysUserRepository.findSysUserEntityByUsername(loginDTO.getUsername());
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", sysUser.getId());
        claims.put("username", sysUser.getUsername());
        claims.put("roleId", sysUser.getRoleId());

        Map<String,String> tokens = tokenService.generateTokens(claims, sysUser.getUsername());

        Map<String,Object> result = new HashMap<>();
        result.put("accessToken",tokens.get("accessToken"));
        result.put("refreshToken",tokens.get("refreshToken"));
        result.put("userInfo",convertUtil.userToDTO(sysUser));

        return result;
    }

    @Override
    public void logout(String refreshToken) throws Exception {
        tokenService.deleteToken(refreshToken);
    }
}
