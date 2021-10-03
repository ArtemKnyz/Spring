package ru.otus.spring.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
@Order(10)
public class LoggingAspect {

    @Around("execution(* ru.otus.spring.dao.*.*(String))")
    public Object logBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Прокси : " + joinPoint.getThis().getClass().getName());
        System.out.println("Класс : " + joinPoint.getTarget().getClass().getName());

        System.out.println("Вызов метода : " + joinPoint.getSignature().getName());
        System.out.println("Аргументы: " + Arrays.toString(joinPoint.getArgs()));

        var res = joinPoint.proceed();

        System.out.println("Результат : " + res);
        return res;

    }
}
