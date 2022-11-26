package com.atguigu.Jsoup.Test;

import com.atguigu.jsoup.pojo.Content;
import com.atguigu.jsoup.pojo.Movie;
import com.atguigu.jsoup.utils.HtmlParseUtil;
import org.junit.Test;

import java.util.List;

public class SearchTest {

    @Test
    public void testJDSearch() throws Exception {
        List<Content> contents = HtmlParseUtil.searchJD("吴京同款手机壳",7);
        contents.forEach(System.out::println);
        System.out.println("总共有"+contents.size()+"条数据");

    }

    @Test
    public void testMovieSearch() throws Exception {
        List<Movie> movies = HtmlParseUtil.getMovie(2);
        System.out.println("记录数:"+movies.size());
        movies.forEach(System.out::println);
    }

}
