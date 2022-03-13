package ru.iteco.account.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import ru.iteco.account.model.annotation.InjectRandom;

import java.lang.reflect.Field;

@Slf4j
@Component
public class InjectRandomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("beanName: " + beanName + " bean: " + bean.getClass().getSimpleName());
        for (Field declaredField : bean.getClass().getDeclaredFields()) {
            if (declaredField.isAnnotationPresent(InjectRandom.class)) {
                declaredField.setAccessible(true);
                InjectRandom annotation = declaredField.getAnnotation(InjectRandom.class);
                int random = getRandom(annotation.min(), annotation.max());
                System.out.println("Set random value in " + declaredField.getName() + "; value " + random);
                ReflectionUtils.setField(declaredField, bean, random);
            }
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    private int getRandom(int min, int max) {
        return min + (int) (Math.random() * ((max + min) + 1));
    }
}
