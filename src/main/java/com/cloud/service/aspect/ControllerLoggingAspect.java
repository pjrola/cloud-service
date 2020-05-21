package com.cloud.service.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Aspect
@Component
public class ControllerLoggingAspect {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(com.cloud.service.annotation.Loggable)")
    public void loggable() {
    }

    @Before("loggable()")
    public void controllerStart(JoinPoint joinPoint) {
        logger.info("Microservice Call Request: "
                + joinPoint.getSignature().getName()
                + "- " + joinPoint.getSignature().getDeclaringTypeName()
        );

        Object[] signatureArgs = joinPoint.getArgs();
        ObjectMapper mapper = new ObjectMapper();

        try {
            if (signatureArgs[0] != null) {
                logger.info("RequestBody=" + mapper.writeValueAsString(signatureArgs[0]));
            }
        } catch (JsonProcessingException ignored) {}
    }

    @AfterReturning(value = "loggable()", returning = "retVal" )
    public void controllerEnd(JoinPoint joinPoint, Object retVal) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        logger.info("Microservice Call Response: "
                + joinPoint.getSignature().getName()
                + joinPoint.getSignature()
        );
        logger.info("ResponseBody=" + mapper.writeValueAsString(retVal));
    }
}
