package com.atguigu.spring.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/*
 *
 * 在切面中,需要通过注解方法将方法标记为通知方法
 *
 *
 * */
@Component
@Aspect
public class LoggerAspect {

    @Pointcut("execution(* com.atguigu.spring.aop.CalculatorImp.*(..))")
    public void pointCut() {
    }


    //切入点表达式:设置在@Before注解中的execution参数中
    //*表示在任意地方加上通知
    //@Before("execution(public int com.atguigu.spring.aop.CalculatorImp.add(int,int ))")
    //@Before("execution(* com.atguigu.spring.aop.CalculatorImp.*(..))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        //joinPoint为切入点
        //joinPoint.getSignature()为获取切入点方法的签名信息
        String name = joinPoint.getSignature().getName();
        //获取连接点对应方法的参数信息
        Object[] args = joinPoint.getArgs();

        System.out.println("LoggerAspect参数为" + Arrays.toString(args));
        System.out.println("LoggerAspect方法名:" + name);
        System.out.println("LoggerAspect:前置通知");
    }

    //后置通知是在目标方法中的finally中执行的
    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint) {
        System.out.println("LoggerAspect:后置通知");
    }

    //返回通知在目标方法返回后执行
    //在返回通知中,若要获取返回值,只需要通过returning属性
    //并且在返回方法中的参数加上与returning属性相同的字段名
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        System.out.println("LoggerAspect,方法" + joinPoint.getSignature().getName() + "结果," + result);
        System.out.println("LoggerAspect:返回通知");
    }

    //@AfterThrowing:异常通知
    //若要获取异常,可通过@AfterThrowing注解中的throwing属性设置字段名
    //然后在异常通知的方法参数中设置与上述相同的参数名,参数类型为Throwable
    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable ex) {
        System.out.println("LoggerAspect:异常通知" + "异常为" + ex);
    }

    @Around("pointCut()")
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {
        Object result;
        try {
            System.out.println("环绕通知-->前置通知");
            result = joinPoint.proceed();
            System.out.println("环绕通知-->返回通知");
        } catch (Throwable e) {
            System.out.println("环绕通知-->异常通知");
            throw new RuntimeException(e);
        } finally {
            System.out.println("环绕通知-->后置通知");
        }
        return result;
    }


}
