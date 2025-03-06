package com.banking.core.crossCuttingConcerns.exceptions.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionLoggerAspect {
    private final Logger logger = LoggerFactory.getLogger(ExceptionLoggerAspect.class);

    @AfterThrowing(pointcut = "execution(* com.banking..*.*(..))", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        logger.error(
            "Exception occurred in {}.{}: {}",
            joinPoint.getSignature().getDeclaringTypeName(),
            joinPoint.getSignature().getName(),
            exception.getMessage()
        );
    }
} 