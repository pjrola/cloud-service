package com.cloud.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeTrackingAspect {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(com.cloud.service.annotation.TrackExecutionTime)")
    public Object trackTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("Method name " + joinPoint.getSignature() + " time taken to execute : " + (endTime - startTime) + "ms");
        return obj;
    }

}
