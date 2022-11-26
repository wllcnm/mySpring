package com.atguigu.spring.Test;

import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {


    @Test
    public void testIOC(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc.xml");

        //获取bean的方式
        //1.通过ioc.getBean(bean的id)
        Student studentOne = (Student) ioc.getBean("studentOne");
        System.out.println("第一种方式"+studentOne);

        //2.通过ioc.getBean(传入类的class)
        //如果配置文件中有id不同,但class相同会报错
        //报错为:No qualifying bean of type 'com.atguigu.spring.pojo.Student'
        //说明一个类在ioc容器中id必须唯一
        //如果一个匹配的bean都没有会报错:
        //NoSuchBeanDefinitionException: No qualifying bean of type 'com.atguigu.spring.pojo.Student' available
        Student studentTwo = ioc.getBean(Student.class);
        System.out.println("第二种方式"+studentTwo);

        //3.根据bean的id和类型获取
        //ioc容器中只能放具体的类,不能放接口和抽象类
        Student studentThree = ioc.getBean("studentOne", Student.class);
        System.out.println("第三种方式"+studentThree);






    }
}
