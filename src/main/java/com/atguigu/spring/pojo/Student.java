package com.atguigu.spring.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer StuId;

    private String StuName;

    private Integer age;

    private String gender;

    private Clazz clazz;

    private String[] hobby;

    private Clazz[]  clazzs;

    private Map<String,Object> teacherMap;


}
