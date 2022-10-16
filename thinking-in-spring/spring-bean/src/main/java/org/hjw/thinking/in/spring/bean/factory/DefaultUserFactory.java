package org.hjw.thinking.in.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ClassName DefaultUserFactory
 * @Description {@link UserFactory} 工厂实现
 * @Author H_jw
 * @Date 2022-09-30 0030 下午 04:34
 * @Version 1.0
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {

    // 基于java注解 @PostConstructor初始化
    @PostConstruct
    public void initPostConstruct() {
        System.out.println("@PostConstruct ：UserFactory 初始化中......");
    }

    @Override
    public void initUserFactory() {
        System.out.println("自定义初始化方法 initUserFactory() ：UserFactory 初始化中......");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet() ：UserFactory 初始化中......");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy ：UserFactory 销毁中......");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean#destroy() ：UserFactory 销毁中......");
    }

    @Override
    public void doPreDestroy() {
        System.out.println("自定义销毁方法 doPreDestroy() ：UserFactory 销毁中......");
    }

    protected void finalize() throws Throwable {
        System.out.println("UserFactory 正在被垃圾回收中......");
    }
}
