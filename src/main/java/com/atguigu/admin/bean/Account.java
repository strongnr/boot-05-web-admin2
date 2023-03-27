package com.atguigu.admin.bean;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;

@Data
public class Account {
    private Integer id;
    private Integer userId;
    private Integer money;
}
