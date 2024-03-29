package org.example.chap6.aspects;

import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

/**
 * @Order : Aspect 실행 순서를 정의하기 위한 어노테이션
 * -> 작을수록 우선 수행
 */
@Aspect
@Order(1)
public class SecurityAspect {

    private Logger logger = Logger.getLogger(SecurityAspect.class.getName());
    @Around(value = "@annotation(org.example.chap6.annotation.ToLog)")
    public Object security(ProceedingJoinPoint joinPoint) throws Throwable {

        logger.info("Security Aspect: Calling the intercepted method");

        Object returnedValue = joinPoint.proceed();

        logger.info("Security Aspect: Method executed and returned " + returnedValue);

        return returnedValue;
        
    }

}
