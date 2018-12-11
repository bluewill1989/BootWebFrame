package com.wzn.bootwebframe.common.config.configure;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * DESCRIPTION:
 *
 * @author will
 * @create 2018-11-26 15:28
 */
//@Component
public class DispatcherServletConfigurer implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof DispatcherServlet) {
            ((DispatcherServlet) bean).setThrowExceptionIfNoHandlerFound(true);
            bean = new com.alibaba.dubbo.remoting.http.servlet.DispatcherServlet();
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}