package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.feedback.default")
public class SysFeedbackDefaultConfig {
    private Byte feedbackStatus;
    private Byte isDeleted;
}