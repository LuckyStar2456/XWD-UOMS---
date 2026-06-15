package com.xwd.xwd_uoms;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordEncoderTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String generateEncryptedPassword() {
        String rawPassword = "HrbEdu123456";

        String encryptedPassword = passwordEncoder.encode(rawPassword);

        System.out.println("明文密码：" + rawPassword);
        System.out.println("加密后密码：" + encryptedPassword);
        return encryptedPassword;
    }

    @Test
    public void varifyPassword() {
        if (passwordEncoder.matches("HrbEdu123456","$2a$10$lqGBsL5etSpyTqW3p3txA.RWh3bm/2LVlrWLgkKYnmCW3nZnxnTAa"))
        {
            System.out.println("1");
        }else{
            System.out.println("2");
        }
        if (passwordEncoder.matches("HrbEdu123456",generateEncryptedPassword())){
            System.out.println("1");
        }else {
            System.out.println("2");
        }
    }
}