package com.atguigu.spring.Test;

import com.atguigu.spring.pojo.Clazz;
import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {

    @Test
    public void testDI01() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");

        Student studentTwo = (Student) ioc.getBean("studentTwo");

        System.out.println(studentTwo);
    }

    @Test
    public void testDI02() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");

        Student studentThree = ioc.getBean("studentThree", Student.class);
        System.out.println(studentThree);
    }

    @Test
    public void testDI03() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");

        Student studentFour = ioc.getBean("studentFour", Student.class);
        System.out.println(studentFour);
    }


    @Test
    public void testDI04() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");

        Student studentFive = ioc.getBean("studentFive", Student.class);
        System.out.println(studentFive);
    }


    @Test
    public void testDI05() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");

        Student studentSix = ioc.getBean("studentSix", Student.class);
        System.out.println(studentSix);
    }

    @Test
    public void testDI06() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Clazz clazzOne = ioc.getBean("clazzOne", Clazz.class);
        System.out.println(clazzOne);
    }

    @Test
    public void testDI07() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student studentSeven = ioc.getBean("studentSeven", Student.class);
        System.out.println(studentSeven);
    }
}
