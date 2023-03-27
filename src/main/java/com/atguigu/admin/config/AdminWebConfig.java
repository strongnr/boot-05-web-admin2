package com.atguigu.admin.config;

import com.atguigu.admin.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//所有请求都被拦截，包括静态资源（css）
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/sql","/city");//放行的请求
    }

}
