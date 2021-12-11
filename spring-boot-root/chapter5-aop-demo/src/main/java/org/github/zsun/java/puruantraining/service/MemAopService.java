package org.github.zsun.java.puruantraining.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class MemAopService {
    // 定义切点
    @Pointcut("execution(* org.github.zsun.java.puruantraining.controller.*.*(..))")
    private void checkMem() {
        // below println would not work
        System.out.println("defining a point cut");
    }

    @Before("checkMem()")
    private void before(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println("url is: " + request.getRequestURL().toString());
        System.out.println("method is: " + joinPoint.getSignature().getName());
    }

    @After("checkMem()")
    private void printMem() {
        System.out.println("After the method, mem usage is: " + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
    }

    /**
     * around would be outside of before + after
     */
    @Around("checkMem()")
    private Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around AOP");
        Object[] args = joinPoint.getArgs();
        Object ret = joinPoint.proceed(args);
        System.out.println("proceed args, result is: " + ret);
        return ret;
    }

    /**
     * afterreturning would be ahead of after
     */
    @AfterReturning(pointcut = "checkMem()", returning = "returnObj")
    private void afterReturning(Object returnObj) {
        System.out.println("return value is: " + returnObj);
    }

    @AfterThrowing(pointcut = "checkMem()", throwing = "e")
    private void afterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("exception is: " + e.getMessage());
    }
}
