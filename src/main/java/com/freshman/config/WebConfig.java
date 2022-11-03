package com.freshman.config;

import com.freshman.interceptor.AdminInterceptor;
import com.freshman.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // 添加拦截器的
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/products/**");
        registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/products/add")
                .addPathPatterns("/products/delete/**")
                .addPathPatterns("/products/update/**");
    }
}
