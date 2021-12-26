package org.github.zsun.java.puruantraining.chapter5filterdemo.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ReqFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("ReqFilter init");
    }

    @Override
    public void destroy() {
        System.out.println("ReqFilter destroy");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("ReqFilter doFilter");
        String url = ((HttpServletRequest) servletRequest).getServletPath();
        System.out.println("url is: " + url);

        if (!url.contains("hacker")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("the url is filtered: " + url);
        }
    }
}
