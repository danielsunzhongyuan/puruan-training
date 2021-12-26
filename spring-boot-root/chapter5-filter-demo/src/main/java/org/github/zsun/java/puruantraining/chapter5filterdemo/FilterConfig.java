package org.github.zsun.java.puruantraining.chapter5filterdemo;

import org.github.zsun.java.puruantraining.chapter5filterdemo.filter.AnotherFilter;
import org.github.zsun.java.puruantraining.chapter5filterdemo.filter.ReqFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean addAnotherFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new AnotherFilter());
        filterRegistrationBean.addUrlPatterns("/*");

        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean addReqFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new ReqFilter());
        filterRegistrationBean.addUrlPatterns("/*");

        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }
}
