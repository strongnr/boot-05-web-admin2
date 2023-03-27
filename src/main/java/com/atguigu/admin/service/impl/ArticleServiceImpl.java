package com.atguigu.admin.service.impl;

import com.atguigu.admin.bean.Article;
import com.atguigu.admin.mapper.ArticleMapper;
import com.atguigu.admin.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
}
