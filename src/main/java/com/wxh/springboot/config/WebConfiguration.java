/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.springboot.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义过滤器-----对web服务器管理的所有web资源：例如Jsp, Servlet, 静态图片文件或静态 html 文件等进行拦截，
 * 从而实现一些特殊的功能。例如实现URL级别的权限访问控制、过滤敏感词汇、压缩响应信息等一些高级功能
 * Spring Boot自动添加了OrderedCharacterEncodingFilter和HiddenHttpMethodFilter,也可以自定义过滤器
 * @author wxh
 * @version $Id: WebConfiguration.java, v 0.1 2017年11月6日 下午5:18:48 wxh Exp $
 */
@Configuration
public class WebConfiguration {
    @Bean
    public RemotelpFilter remotelpFilter() {
        return new RemotelpFilter();
    }

    /**
     * 过滤器注册
     * JavaConfig方式使用bean
     * @return
     */
    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "parmaValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }

    /**
     * 自定义过滤器
     *
     */
    public class MyFilter implements Filter {

        /** 
         * @param filterConfig
         * @throws ServletException
         * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
         */
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
        }

        /** 
         * @param request
         * @param response
         * @param chain
         * @throws IOException
         * @throws ServletException
         * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
         */
        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                                                                                                 throws IOException,
                                                                                                 ServletException {

            HttpServletRequest req = (HttpServletRequest) request;
            /*
             * URI，是uniform resource identifier，统一资源标识符，用来唯一的标识一个资源。
             * 而URL是uniform resource locator，统一资源定位器，它是一种具体的URI
             */
            System.out.println("this is MyFilter,url:" + req.getRequestURI());
            // 过滤器链表 request -> filter1 -> filter2 ->filter3 -> …. -> request resource.
            chain.doFilter(request, response);
        }

        /** 
         * 
         * @see javax.servlet.Filter#destroy()
         */
        @Override
        public void destroy() {
        }

    }
}
