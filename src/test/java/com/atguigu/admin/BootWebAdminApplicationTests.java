package com.atguigu.admin;

import com.atguigu.admin.bean.Dingdan;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.mapper.DingdanMapper;
import com.atguigu.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@SpringBootTest
public class BootWebAdminApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from `user`", long.class);
//        jdbcTemplate.queryForList("select * from `user` with id = 1");
        log.info("记录数：{}",aLong);
        log.info("数据类型：{}",dataSource.getClass());
    }

//    @Autowired
//    UserMapper userMapper;
//    @Test
//    void testUserMapper(){
//        User user = userMapper.selectById(1L);
//        log.info("用户信息：{}",user);
//
//    }
//    @Autowired
//    DingdanMapper dingdanMapper;
//    @Test
//    void contextLoad(){
//        List<Dingdan> dingdans = dingdanMapper.selectList(null);
//        dingdans.forEach(System.out::println);
//    }
}
