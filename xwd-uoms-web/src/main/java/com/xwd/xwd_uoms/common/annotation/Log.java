package com.xwd.xwd_uoms.common.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块名称（如：用户管理、组织管理）
     */
    String module() default "";

    /**
     * 操作描述（如：添加用户、删除组织）
     */
    String operation() default "";
}