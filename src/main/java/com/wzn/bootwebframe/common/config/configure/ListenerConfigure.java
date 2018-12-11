package com.wzn.bootwebframe.common.config.configure;

import com.alibaba.dubbo.remoting.http.servlet.BootstrapListener;
import com.alibaba.dubbo.remoting.http.servlet.DispatcherServlet;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DESCRIPTION:
 *
 * @author will
 * @create 2018-11-26 14:40
 */
@Configuration
public class ListenerConfigure {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public ServletListenerRegistrationBean listenerRegist() {
        ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
        srb.setListener(new BootstrapListener());
        System.out.println("listener");
        return srb;
    }

//    @Bean
//    public ServletRegistrationBean dispatcherRegistration(){
//        System.out.println("restServlet");
//        //dubbo.remoting.http.servlet.DispatcherServlet
//        DispatcherServlet rest_dispatcherServlet
//                = new DispatcherServlet();
//
//        //用ServletRegistrationBean包装servlet
//        ServletRegistrationBean registrationBean
//                = new ServletRegistrationBean(rest_dispatcherServlet);
//        registrationBean.setLoadOnStartup(1);
//        registrationBean.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME);
//        registrationBean.addUrlMappings("/");
//        return registrationBean;
//    }

}