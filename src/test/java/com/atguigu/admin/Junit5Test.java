package com.atguigu.admin;


import org.junit.jupiter.api.*;

@DisplayName("junit5功能测试类")
public class Junit5Test {
    @DisplayName("测试displayname注解")
    @Test
    void testDisplayName(){
        System.out.println(1);
    }
    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试开始");
    }
    @AfterEach
    void testAfterEach(){
        System.out.println("测试结束");
    }
    @DisplayName("测试前置条件")
    @Test
    void testassumptions(){
        Assumptions.assumeTrue(true,"结果不是true");
        System.out.println("111111111");
    }
}
