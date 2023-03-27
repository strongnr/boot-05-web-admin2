package com.atguigu.admin.controller;

import com.atguigu.admin.bean.Dingdan;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.mapper.DingdanMapper;
import com.atguigu.admin.mapper.UserMapper;
import com.atguigu.admin.service.DingdanService;
import com.atguigu.admin.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    @GetMapping("/basic_table")
    public String basic_table(){
        return "table/basic_table";
    }

    @Autowired
    UserService userService;
    @Autowired
    DingdanService dingdanService;


@GetMapping("/dynamic_table")
public String dynamic_table(Model model){//@RequestParam(value="pn",defaultValue = "1") Integer pn,
    //表格内容的遍历
    //        List<User> users = Arrays.asList(new User("zhangsan","123456"),new User("lisi","123")
//                ,new User("王五","456"));
//        model.addAttribute("users",users);
    //从数据库中查出user表中的用户进行展示
    List<User> list = userService.list();
    model.addAttribute("users",list);
    List<Dingdan> list2 = dingdanService.list();
    model.addAttribute("dings",list2);
////    //构造分页参数
//    Page<User> UserPage = new Page<>(pn, 2);
////    //调用page进行分页
//    Page<User> Page = userService.page(UserPage, null);
//    long current = Page.getCurrent();
//    long Pages = Page.getTotalPages();
//    long total = Page.getTotal();
//    List<User> records = page.getRecords();
//
////
//    model.addAttribute("page",Page);

    return "table/dynamic_table";
}





    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                             RedirectAttributes ra) {

        userService.removeById(id);

        ra.addAttribute("pn", pn);
        return "redirect:/dynamic_table";
    }

    @Autowired
    DingdanMapper dingdanMapper;
    @GetMapping("/Dingdan/delete/{id}")
    public String deleteDingdan(@PathVariable("id") Long id) {
        QueryWrapper<Dingdan> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("d_id",id);
        int result = dingdanMapper.delete(queryWrapper);
        System.out.println("result:" + result);
        return "redirect:/dynamic_table";
    }
@Autowired
UserMapper userMapper;
    @PostMapping("/user/update")
    public String updateUser(@RequestParam("name")String name,
                                @RequestParam("age") Integer age,
                                @RequestParam("email")String email,
                                @RequestParam("password")String password,
                                @RequestParam("userName") String username){
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.like("name",username);
        if (name != null){
            userUpdateWrapper.set("name",name);
        }
        if (age != null){
            userUpdateWrapper.set("age",age);
        }
        if (email != null){
            userUpdateWrapper.set("email",email);
        }
        if (password != null ){
            userUpdateWrapper.set("password",password);
        }
        int result = userMapper.update(null,userUpdateWrapper);
        System.out.println("result=" + result);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }
    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}
