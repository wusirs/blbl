package com.heisenberg.blbl.aspect;

import com.heisenberg.blbl.annotation.RequestLockAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RequestLock {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestLock.class);

    @Around(value = "@annotation(requestLockAnnotation)", argNames = "pjp,requestLockAnnotation")
    public Object requestLock(ProceedingJoinPoint pjp, RequestLockAnnotation requestLockAnnotation) {
        Object resObj = null;
        try {
            resObj = pjp.proceed();
        } catch (Throwable e) {
            LOGGER.error(e.getMessage(), e);
        }
        return resObj;
    }
}
