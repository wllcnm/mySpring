package com.atguigu.spring.Test;

import com.atguigu.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class lifeCycleTest {
    /*
    * bean的生命周期
    * 1.实例化:通过无参构造方法实例化
    * 2.依赖注入
    * 3.初始化
    * 4.销毁:在ioc容器关闭的同时销毁
    * */

    @Test
    public void testLife(){
        ConfigurableApplicationContext ioc=new ClassPathXmlApplicationContext("spring-lifeCycle.xml");

        User user = ioc.getBean(User.class);

        System.out.println(user);

        ioc.close();

    }

}
