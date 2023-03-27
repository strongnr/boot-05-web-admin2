package com.atguigu.admin.bean;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class Article {
    private Long id;
    private String content;
    private String name;
    private Timestamp date;
}
