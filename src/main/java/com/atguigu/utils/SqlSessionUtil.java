package com.atguigu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    public static SqlSession getSqlSession(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();

            SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);

            SqlSession sqlSession = build.openSession(true);

            return sqlSession;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }




}
