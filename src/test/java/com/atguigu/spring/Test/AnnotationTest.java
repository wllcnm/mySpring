package com.atguigu.spring.Test;

import com.atguigu.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {

    @Test
    public void testAnnotation() {
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-annotation-scanning.xml");

        UserController userController = ioc.getBean(UserController.class);

        userController.saveUser();

    }


}
