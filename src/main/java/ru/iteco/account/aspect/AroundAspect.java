package ru.iteco.account.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.iteco.account.model.User;

import java.util.List;

@Slf4j
@Aspect
@Component
public class AroundAspect {

    @Value("#{'${user-accept}'.split(',')}")
    public List<String> userAccept;

    @Around(value = "allGetMethodWithUser(user)")
    public Object aroundAllGetMethodWithUserArgAdvice(ProceedingJoinPoint proceedingJoinPoint,
                                                      User user) throws Throwable {
        log.info("aroundAllGetMethodWithUserArgAdvice:: Around {} with User: {}",
                proceedingJoinPoint.getSignature().toShortString(), user);
        if (userAccept.contains(user.getName())) {
            log.info("User: {} accept!", user);
            return proceedingJoinPoint.proceed();
        } else {
            throw new RuntimeException("Decline!");
        }
    }


    @Around(value = "execution(* save*(..))")
    public Object aroundAllSaveMethodAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("aroundAllSaveMethodAdvice:: Around {}", proceedingJoinPoint.getSignature().toShortString());
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("Error!", throwable);
            throw new RuntimeException("Around Exception!");
        }
    }

    @Pointcut("execution(* get*(..,ru.iteco.account.model.User, ..)) && args(user)")
    public void allGetMethodWithUser(User user) {
    }

}