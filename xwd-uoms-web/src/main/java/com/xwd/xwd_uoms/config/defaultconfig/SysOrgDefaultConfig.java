package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.org.default")
public class SysOrgDefaultConfig {
    private String type;
    private String orgDesc;
    private Byte status;
    private Byte isDeleted;
}