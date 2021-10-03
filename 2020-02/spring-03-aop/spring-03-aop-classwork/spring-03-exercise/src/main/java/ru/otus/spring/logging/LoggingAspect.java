package ru.otus.spring.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(10)
public class LoggingAspect {

    @Before("execution(* ru.otus.spring.dao.*.*(String))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Прокси : " + joinPoint.getThis().getClass().getName());
        System.out.println("Класс : " + joinPoint.getTarget().getClass().getName());

        System.out.println("Вызов метода : " + joinPoint.getSignature().getName());
    }
}
