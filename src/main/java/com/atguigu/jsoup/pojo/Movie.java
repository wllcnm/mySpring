package com.atguigu.jsoup.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private Integer movieId;

    private  String movieName;

    private String movieImg;

    private String movieMagnetic;
}
