package com.xwd.xwd_uoms.common.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE}) // 可用于方法、类
@Retention(RetentionPolicy.RUNTIME) // 运行时生效
@Documented
public @interface RequirePermission {
    String object();
    String operation();
}
