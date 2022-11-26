package com.atguigu.spring.Test;

import com.atguigu.spring.aop.Calculator;
import com.atguigu.spring.aop.CalculatorImp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    @Test
    public void testAnnotationAop(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-aop-annotation.xml");

        Calculator calculator = ioc.getBean(Calculator.class);

        calculator.add(1,1);

        //calculator.div(1,0);

    }


}
