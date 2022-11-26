package com.atguigu.spring.aop;


import org.springframework.stereotype.Component;

@Component
public class CalculatorImp implements Calculator {
    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public int sub(int x, int y) {
        return x - y;
    }

    @Override
    public int mul(int x, int y) {
        return x * y;
    }

    @Override
    public double div(int x, int y) {
        return x / y;
    }
}
