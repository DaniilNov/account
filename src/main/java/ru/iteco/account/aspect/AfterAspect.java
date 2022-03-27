package ru.iteco.account.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class AfterAspect {

    @AfterReturning(value = "allGetMethod()", returning = "result")
    public void afterCallGetMethod(JoinPoint.StaticPart staticPart, Object result) {
        log.info("afterCallGetMethod:: After {} with result: {}", staticPart.toShortString(), result);
    }

    @AfterThrowing(value = "allSaveMethod()", throwing = "exception")
    public void afterSaveMethodThrowAdvice(JoinPoint.StaticPart staticPart, Exception exception) {
        log.info("afterSaveMethodThrowAdvice:: After {} with exception: {}", staticPart.toShortString(), exception.getMessage());
    }

    @After(value = "allGetMethod() || allSaveMethod()")
    public void afterAllGetOrSaveMethodAdvice(JoinPoint joinPoint){
        log.info("afterAllGetOrSaveMethodAdvice:: After {} with args: {}", joinPoint.toShortString(), joinPoint.getArgs());
    }

    @Pointcut("execution(* get*(..))")
    public void allGetMethod() {
    }

    @Pointcut("execution(* save*(..))")
    public void allSaveMethod() {
    }
}
