package com.zhuai.localtcc.annotation;

import com.zhuai.localtcc.handler.BizServiceHandler;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 业务处理切面
 * @author zhuaizhuai
 */

@Component
@Aspect
@Slf4j
public class BizProcessAspect {

    @Pointcut("@annotation(com.zhuai.localtcc.annotation.BizProcess)")
    public void bizProcess() {
    }

    @Around("bizProcess()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 业务处理
        Object result = joinPoint.proceed();
        BizServiceHandler handler = (BizServiceHandler) joinPoint.getTarget();
        BizServiceHandler.serviceDoneHandlers.get().add(handler);
        return result;
    }

}

