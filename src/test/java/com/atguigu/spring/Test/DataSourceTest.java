package com.atguigu.spring.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class DataSourceTest {


    @Test
    public void testDruid() throws SQLException {
        ApplicationContext druid=new ClassPathXmlApplicationContext("spring-datasource.xml");

        DruidDataSource dataSource = druid.getBean("dataSource", DruidDataSource.class);

        DruidPooledConnection connection = dataSource.getConnection();

        System.out.println(connection);


    }

}
