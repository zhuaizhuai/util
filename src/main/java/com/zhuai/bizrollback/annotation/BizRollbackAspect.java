package com.zhuai.bizrollback.annotation;

import com.zhuai.bizrollback.handler.BizServiceHandler;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 业务回滚切面
 * @author zhuaizhuai
 */

@Component
@Aspect
@Slf4j
public class BizRollbackAspect {

    @Pointcut("@annotation(com.zhuai.bizrollback.annotation.BizRollback)")
    public void rollback() {
    }

    @Around("rollback()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 业务处理
        Object result = proceedingJoinPoint.proceed();

        Signature signature =  proceedingJoinPoint.getSignature();
        Method method = ( (MethodSignature)signature ).getMethod();
        Method realMethod = proceedingJoinPoint.getTarget().getClass().getDeclaredMethod(signature.getName(), method.getParameterTypes());
        BizRollback annotation = realMethod.getAnnotation(BizRollback.class);

        return result;
    }

    @AfterThrowing(pointcut = "rollback()", throwing = "e")
    public void doAfterThrow(JoinPoint joinPoint, Exception e) {
        for (BizServiceHandler bizServiceHandler : BizServiceHandler.serviceDoneHandlers.get()) {
            bizServiceHandler.rollback();
        }
    }


    @After("rollback()")
    public void After(JoinPoint joinPoint) {
        BizServiceHandler.serviceDoneHandlers.remove();
    }

}

