package com.eva.base.configure;

import com.eva.base.interceptor.AdminLoginInterceptor;
import com.eva.base.properties.BaseProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * Created by Jamin on 2017/5/22.
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Resource
    private AdminLoginInterceptor adminLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminLoginInterceptor).addPathPatterns("/**");
    }

}
