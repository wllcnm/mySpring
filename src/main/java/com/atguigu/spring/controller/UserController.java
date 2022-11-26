package com.atguigu.spring.controller;


import com.atguigu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {


    /*
    * 如果一个接口有多个实现类,则可以通过
    * @Qualifier注解指定要注入的类的ID
    *
    * */
    @Autowired
    @Qualifier("userServiceImp2")
    private UserService userService;

    public void saveUser(){
        //实现UseServiceImp2的实现类
        userService.saveUser();

    }


}
