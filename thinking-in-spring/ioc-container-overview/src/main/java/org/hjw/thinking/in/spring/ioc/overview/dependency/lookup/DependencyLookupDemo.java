package org.hjw.thinking.in.spring.ioc.overview.dependency.lookup;

import org.hjw.thinking.in.spring.ioc.overview.annotation.Super;
import org.hjw.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @ClassName DependencyLookupDemo
 * @Description 依赖查找示例： 名称 ，类型
 * @Author H_jw
 * @Date 2022-09-26 0026 下午 02:12
 * @Version 1.0
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        // 配置 xml 配置文件
        // 启动 spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        // 通过类型查找单一对象
        lookupByType(beanFactory);
        // 通过类型查找集合对象
        lookupCollectionByType(beanFactory);
        // 通过注解查找
        lookupByAnnotation(beanFactory);
        // 实时查找
        lookupInRealTime(beanFactory);
        // 延时查找
        lookupInLazyTime(beanFactory);
    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> userMap = listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("实时注解查找所有User对象：userMap = " + userMap);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("实时类型查找所有User对象：userMap = " + userMap);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("通过类型实时查找： user = " + user);
    }

    private static void lookupInLazyTime(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延时查找 ：user = " + user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找 ：user = " + user);
    }
}
