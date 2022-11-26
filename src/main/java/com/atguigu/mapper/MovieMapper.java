package com.atguigu.mapper;

import com.atguigu.jsoup.pojo.Movie;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieMapper {

    void  insertMovie(@Param("movies") List<Movie> movies);

}
