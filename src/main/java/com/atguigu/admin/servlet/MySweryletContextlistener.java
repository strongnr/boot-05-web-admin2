package com.atguigu.admin.servlet;

import javafx.collections.SetChangeListener;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Slf4j
//@WebListener
public class MySweryletContextlistener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("MySweryletContextlistener监听到项目初始化完成");
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("MySweryletContextlistener监听到项目销毁");
    }
}
