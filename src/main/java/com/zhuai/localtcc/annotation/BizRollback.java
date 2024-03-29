package com.zhuai.localtcc.annotation;

import java.lang.annotation.*;

/**
 * 回滚注解
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BizRollback {

    boolean rollback() default true;
}
