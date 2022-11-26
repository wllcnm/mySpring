package com.atguigu.Jsoup.Test;

import com.atguigu.jsoup.pojo.Movie;
import com.atguigu.jsoup.utils.HtmlParseUtil;
import com.atguigu.mapper.MovieMapper;
import com.atguigu.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class InsertMovieTest {

    @Test
    public void testInsertMovie() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        MovieMapper mapper = sqlSession.getMapper(MovieMapper.class);
        List<Movie> movies = HtmlParseUtil.getMovie(10);
        mapper.insertMovie(movies);
    }

}
