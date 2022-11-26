package com.atguigu.spring.service.imp;

import com.atguigu.spring.service.BookService;
import com.atguigu.spring.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckoutServiceImp implements CheckoutService {

    @Autowired
    private BookService bookService;


    /*
    * @Transactional(propagation = Propagation.REQUIRED使用调用者的事务
    * @Transactional(propagation = Propagation.REQUIRES_NEW)使用被调用者的事务
    *这个注解使用在被调用方法上
    *
    * */
    @Transactional
    @Override
    public void checkout(Integer userId, Integer[] bookIds) {
        for (Integer bookId : bookIds) {
            bookService.buyBook(userId,bookId);
        }
    }
}
