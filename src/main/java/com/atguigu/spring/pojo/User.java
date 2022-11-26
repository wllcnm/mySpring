package com.atguigu.spring.pojo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {

    private String uName;

    private String uId;

    public User() {
        System.out.println("生命周期1:实例化");
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        System.out.println("生命周期2:依赖注入");
        this.uName = uName;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public void  initMethod(){

        System.out.println("生命周期3:初始化");
    }
    public void destroyMethod(){
        System.out.println("生命周期4:销毁");

    }

    @Override
    public String toString() {
        return "User{" +
                "uName='" + uName + '\'' +
                ", uId='" + uId + '\'' +
                '}';
    }
}
