package com.example.khairislimani.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoginAspect {

    @After("execution(void com.example.khairislimani.services.*.get*(..))")

    public void logMethodExit(JoinPoint joinPoint) {

        String name = joinPoint.getSignature().getName();

        log.info(name);
    }

}
