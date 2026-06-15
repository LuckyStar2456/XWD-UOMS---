package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.task.feedback.default")
public class SysTaskFeedbackDefaultConfig {
    private Byte reviewStatus;
}
