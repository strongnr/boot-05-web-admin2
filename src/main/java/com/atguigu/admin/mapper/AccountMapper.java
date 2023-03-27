package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.relational.core.sql.In;

@Mapper
public interface AccountMapper {
    public Account getAcct(Integer id);
}
