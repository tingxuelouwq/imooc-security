package com.imooc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 类名: TimeAspect<br/>
 * 包名：com.imooc.aop<br/>
 * 作者：kevin<br/>
 * 时间：2019/9/21 23:41<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
//@Aspect
//@Component
public class TimeAspect {

    @Around("execution(* com.imooc.controller.UserController.*(..))")
    public Object handlControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("time aspect start");
        System.out.println(joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("arg is "+arg);
        }
        long start = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        System.out.println("time aspect 耗时:"+ (System.currentTimeMillis() - start));
        System.out.println("time aspect end");
        return object;
    }
}
