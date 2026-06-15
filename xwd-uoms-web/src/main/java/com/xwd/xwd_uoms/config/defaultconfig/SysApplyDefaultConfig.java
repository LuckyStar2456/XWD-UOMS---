package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.apply.default")
public class SysApplyDefaultConfig {
    private Byte applyStatus;
    private Byte isDeleted;
}