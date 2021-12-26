package org.github.zsun.java.puruantraining.chapter5filterdemo.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class AnotherFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AnotherFilter init");
    }

    @Override
    public void destroy() {
        System.out.println("AnotherFilter destroy");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AnotherFilter doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
