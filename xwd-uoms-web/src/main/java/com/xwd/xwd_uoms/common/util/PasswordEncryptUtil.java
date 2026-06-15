package com.xwd.xwd_uoms.common.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncryptUtil {
    private static final BCryptPasswordEncoder BCRYPT_PASSWORD_ENCODER = new BCryptPasswordEncoder();

    public String encryptPassword(String password){
        if (password == null || password.trim().isEmpty()){
            throw new IllegalArgumentException("密码不能为空.");
        }
        return BCRYPT_PASSWORD_ENCODER.encode(password);
    }

    public boolean matchPassword(String password,String encryptedPassword){
        if (password == null || password.trim().isEmpty() || encryptedPassword == null || encryptedPassword.trim().isEmpty()){
            throw new IllegalArgumentException("密码不存在.");
        }
        return BCRYPT_PASSWORD_ENCODER.matches(password,encryptedPassword);
    }
}
