package com.atguigu.spring.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clazz {
    private String cid;

    private String cname;

    private List<Student> studentList;

}
