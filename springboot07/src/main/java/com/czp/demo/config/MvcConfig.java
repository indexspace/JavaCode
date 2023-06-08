package com.czp.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    // 自定义视图解析器MyViewResolver并重写方法
    public static class MyViewResolver implements ViewResolver {
        @Override
        public View resolveViewName (String viewName, Locale locale){
            return null;
        }
    }
    // 将自定义的视图解析器注册Bean, 自定义配置完成
    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    // 自定义视图跳转, url:czp -> test.html
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("czp").setViewName("hello");
    }

}
