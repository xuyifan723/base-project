package com.xuyifan.basecontroller.config;

import com.xuyifan.basecontroller.config.filter.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import java.util.List;

/**
 * @author Xu yifan
 * @Ddecription 配置注册
 * @date 2019/8/12 15:37
 * @Version 1.0
 */
@Configuration
public class AppAuthConfiguration extends WebMvcConfigurerAdapter {
    //关键，将拦截器作为bean写入配置中
    @Bean
    public AuthInterceptor getSecurityInterceptor() {
        return new AuthInterceptor();
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(getSecurityInterceptor());
        ir.addPathPatterns("/**");
        // 配置拦截的路径
        ir.excludePathPatterns("/gateway/*");
        // 配置不拦截的路径
//        ir.excludePathPatterns("**/swagger-ui.html");
        // 还可以在这里注册其它的拦截器
//        registry.addInterceptor(new AppAuthInterceptor()).addPathPatterns("/api/**");
    }

    /**
     * 功能描述:添加方法参数解析器
     * @Param: [argumentResolvers]
     * @Return: void
     * @Author: Xu yifan
     * @Date: 2019/8/12 16:18
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentUserMethodArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
    }

    @Bean
    public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver() {
        return new CurrentUserMethodArgumentResolver();
    }
}
