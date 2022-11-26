package com.atguigu.spring.Test;

import com.atguigu.spring.pojo.HelloSpring;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringTest {

    @Test
    public void testSpring(){
        //获取ioc容器
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取ioc容器中的bean
        //将获取到的bean强转为实体类
        HelloSpring helloWorld = (HelloSpring) ioc.getBean("helloSpring");
        //调用实体类中的方法
        helloWorld.sayHello();

    }

}
