package com.atguigu.admin.controller;

import com.atguigu.admin.bean.Account;
import com.atguigu.admin.bean.City;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.mapper.UserMapper;
import com.atguigu.admin.service.UserService;
import com.atguigu.admin.service.impl.AccountServiceImpl;
import com.atguigu.admin.service.impl.CityServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class indexController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from `user`", long.class);
        return aLong.toString();
    }


    @Autowired
    UserMapper userMapper;

    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }
    @PostMapping("/login")
    public String main(User user, HttpSession httpSession, Model model,@RequestParam("name")String name
    ,@RequestParam("password")String password,@RequestParam("type")String type){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();//条件构造器
        queryWrapper.like("name",name).like("password",password);
        List<User> list = userMapper.selectList(queryWrapper);

        if (!list.isEmpty()){//"admin".equals(user.getUserName()
//            用户名密码不为空
            httpSession.setAttribute("loginUser",user);
            //        登录成功后重定向到main.html，重定向防止表单重复提交
            if ("0".equals(type)){
                return "redirect:/main.html";
            }
            if ("1".equals(type)){
                return "redirect:/sql";
            }
            return "login";
        }
//        else if(!(list.isEmpty()) && "1".equals(user.getType())){
//            httpSession.setAttribute("loginUser",user);
//            //        登录成功后重定向到main.html，重定向防止表单重复提交
//            return "redirect:/mainS.html";
//        }
        else {
            model.addAttribute("msg","账号密码错误");
            //回到登陆页面
            return "login";
        }

    }
    @GetMapping("/main.html")
    public String mainPage(HttpSession httpSession,Model model){
        log.info("当前方式是：{}","maginPage");
////        是否登录 拦截器过滤器
//        Object loginUser = httpSession.getAttribute("loginUser");
//        if (loginUser != null){
//            return "main";
//        }else {
////            回到登录页面
//            model.addAttribute("msg","请重新登录");
//            return "login";
//        }
        return "main";
    }

    @Autowired
    AccountServiceImpl accountServiceImpl;
    @ResponseBody
    @GetMapping("/acct")
    public Account getById(@RequestParam("id")Integer id){
        return accountServiceImpl.getAcctById(id);
    }

    @Autowired
    CityServiceImpl cityServiceImpl;
    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id")Long id){
        return cityServiceImpl.getById(id);
    }
    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city){
        cityServiceImpl.saveCity(city);
        return city;
    }
    @GetMapping("/table")
    public String table(){
        return "table";
    }





}
