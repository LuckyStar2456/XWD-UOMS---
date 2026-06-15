package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.user.default")
public class SysUserDefaultConfig {
    private Long roleId;
    private Byte status;
    private Byte isDeleted;
    private String password;
}
