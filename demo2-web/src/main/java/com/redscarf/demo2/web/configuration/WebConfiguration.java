package com.redscarf.demo2.web.configuration;

import com.redscarf.demo2.web.interceptor.IpInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * <p>function:
 * <p>User: LeeJohn
 * <p>Date: 2016/7/18
 * <p>Version: 1.0
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private IpInterceptor ipInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ipInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
