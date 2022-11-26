package com.atguigu.spring.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
*
* @Order注解:设置切面的优先级,数字越低,优先级越高
* */
@Component
@Aspect
@Order(1)
public class ValidateAspect {

    @Before("com.atguigu.spring.aop.LoggerAspect.pointCut()")
    public void beforeMethod(){
        System.out.println("ValidateAspect:前置通知");
    }

    @AfterReturning(value = "com.atguigu.spring.aop.LoggerAspect.pointCut()",returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint,Object result){
        System.out.println("结果为"+(Integer.parseInt(String.valueOf(result))+1));
    }


}
