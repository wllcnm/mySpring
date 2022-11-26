package com.atguigu.spring.dao.Imp;

import com.atguigu.spring.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao {


    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }

    @Override
    public void saveUser2() {
        System.out.println("保存成功22222");
    }
}
