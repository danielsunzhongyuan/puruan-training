package org.github.zsun.java.puruantraining.chapter5interceptordemo;

import org.github.zsun.java.puruantraining.chapter5interceptordemo.interceptor.ParamInterceptor;
import org.github.zsun.java.puruantraining.chapter5interceptordemo.interceptor.UrlInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigInterceptor implements WebMvcConfigurer {
    @Autowired
    private UrlInterceptor urlInterceptor;

    @Autowired
    private ParamInterceptor paramInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(urlInterceptor).addPathPatterns("/**");
        registry.addInterceptor(paramInterceptor).addPathPatterns("/*/login/*");
    }
}
