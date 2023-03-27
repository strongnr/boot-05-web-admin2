package com.atguigu.admin.controller;

import com.atguigu.admin.bean.Article;
import com.atguigu.admin.bean.Dingdan;
import com.atguigu.admin.mapper.ArticleMapper;
import com.atguigu.admin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @GetMapping("/article")
    public String dynamic(Model model){
        List<Article> list = articleService.list();
        model.addAttribute("articles",list);
        return "article";
    }

}
