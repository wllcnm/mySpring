package com.atguigu.spring.service.imp;

import com.atguigu.spring.dao.BookDao;
import com.atguigu.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/*
 * @Transactional:开启声明式事务,可作用与方法和类上,作用与类上则表明,类中的所用方法都会被进行事务管理
 * @Transactional中的属性:readOnly= true表明对数据库的操作为只读,不允许修改,
 * 如果执行会抛出异常:Connection is read-only. Queries leading to data modification are not allowed
 *
 * */

@Transactional(
        //readOnly = true

        //timeout:设置超时时间,如果超时,则会强制回滚
        //如果超时会抛异常:TransactionTimedOutException: Transaction timed out
        timeout = 3,

        //回滚策略
        //noRollbackFor:如果抛出了某种类型的异常,则不进行回滚
        //noRollbackFor = ArithmeticException.class

        //隔离级别
        isolation = Isolation.READ_COMMITTED,

        //事务的传播性
        propagation = Propagation.REQUIRES_NEW
)
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;


    @Override
    public void buyBook(Integer userId, Integer bookId) {

//        try {
//            //休眠5秒
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


        //获取图书的价格
        Integer price = bookDao.getPriceByBookId(bookId);

        bookDao.updateStock(bookId);

        bookDao.updateBalance(userId, price);

        //模拟产生运行时异常
        //System.out.println(1/0);

    }


}
