package com.atguigu.spring.Test;

import com.atguigu.spring.pojo.User;
import com.beust.ah.A;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryTest {

    @Test
    public void testFactory(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-factory.xml");

        User user = ioc.getBean(User.class);

        System.out.println(user);


    }


}
