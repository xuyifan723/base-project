package com.xuyifan.projectinit.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: xuyifan
 * @Date: 2020/7/7
 */
@Component
public class MyResourceConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //将所有/static/**访问都映射到classpath:/static/目录下
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");


}
}
