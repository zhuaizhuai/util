package com.zhuai.bizrollback.annotation;

import java.lang.annotation.*;

/**
 * 业务处理注解
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BizProcess {
}
