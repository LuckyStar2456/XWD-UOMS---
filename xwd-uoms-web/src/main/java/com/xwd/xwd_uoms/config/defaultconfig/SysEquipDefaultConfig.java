package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.equip.default")
public class SysEquipDefaultConfig {
    private String equipmentDesc;
    private Byte status;
    private Byte isDeleted;
}
