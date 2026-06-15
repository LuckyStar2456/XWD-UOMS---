package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.dept.default")
public class SysDeptDefaultConfig {
    private String deptDesc;
    private Byte status;
    private Byte isDeleted;
}