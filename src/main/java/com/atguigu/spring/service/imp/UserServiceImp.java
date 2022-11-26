package com.atguigu.spring.service.imp;

import com.atguigu.spring.dao.UserDao;
import com.atguigu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired()
    private UserDao userDao;

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
