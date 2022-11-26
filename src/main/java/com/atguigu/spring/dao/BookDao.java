package com.atguigu.spring.dao;

public interface BookDao {

    /*
    * 根据图书id查询价格
    *
    * */
    void updateStock(Integer bookId);

    /*
    * 根据用户id和图书id更新用户余额
    * */
    void updateBalance(Integer userId, Integer price);

    /*
    * 根据图书id获取价格
    * */
    Integer getPriceByBookId(Integer bookId);
}
