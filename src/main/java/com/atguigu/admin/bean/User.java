package com.atguigu.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("user")
public class User {
//    mybatisplus要求所有属性都在数据库里，否则用@TableField(exist = false)表示该属性不存在数据库中
    @TableField(exist = false)
    private String userName;

    private String password;
    private Integer type;
    private Long id;
    private String name;
    private  Integer age;
    private String email;
}
