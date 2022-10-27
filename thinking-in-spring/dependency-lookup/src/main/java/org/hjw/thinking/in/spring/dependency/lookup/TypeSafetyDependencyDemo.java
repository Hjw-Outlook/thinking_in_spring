package org.hjw.thinking.in.spring.dependency.lookup;

import org.hjw.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName TypeSafetyDependencyDemo
 * @Description 安全依赖查找 示例
 * @Author H_jw
 * @Date 2022-10-27 0027 下午 02:41
 * @Version 1.0
 */
public class TypeSafetyDependencyDemo {

    public static void main(String[] args) {
        // 创建容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 把当前类作为配置类
        applicationContext.register(TypeSafetyDependencyDemo.class);
        // 启动容器
        applicationContext.refresh();
        // BeanFactory#getBean 方法安全
        lookupByBeanFactoryGetBean(applicationContext);
        // ObjectFactory#getObject 方法安全
        lookupByObjectFactoryGetObject(applicationContext);
        // ObjectProvider#getIfAvailable 方法安全
        lookupByObjectProviderGetIfAvailable(applicationContext);

        // ListableBeanFactory#getBeansOfType 方法安全
        lookupByListableBeanFactoryGetBeansOfType(applicationContext);
        // ObjectProvider#Stream 方法安全
        lookupByObjectProviderStreamOps(applicationContext);

        // 注意：层次性依赖查找的安全性取决于其扩展的单一或集合类型的 BeanFactory 接口

        // 关闭应用上下文
        applicationContext.close();
    }

    private static void lookupByObjectProviderStreamOps(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        displayException("lookupByObjectProviderStreamOps()", () -> userObjectProvider.stream().forEach(System.out::println));
    }

    private static void lookupByListableBeanFactoryGetBeansOfType(ListableBeanFactory beanFactory) {
        displayException("lookupByListableBeanFactoryGetBeansOfType()", () -> beanFactory.getBeansOfType(User.class));
    }

    private static void lookupByObjectProviderGetIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        displayException("lookupByObjectProviderGetIfAvailable()", userObjectProvider::getIfAvailable);
    }

    private static void lookupByObjectFactoryGetObject(AnnotationConfigApplicationContext applicationContext) {
        // ObjectFactory is ObjectProvider
        ObjectFactory<User> userObjectFactory = applicationContext.getBeanProvider(User.class);
        displayException("lookupByObjectFactoryGetObject()", userObjectFactory::getObject);
    }

    private static void lookupByBeanFactoryGetBean(AnnotationConfigApplicationContext applicationContext) {
        displayException("lookupByBeanFactoryGetBean()", () -> applicationContext.getBean(User.class));
    }

    private static void displayException(String source, Runnable runnable) {
        System.err.println("========================");
        System.err.println("source from -> " + source);
        try {
            runnable.run();
        } catch (BeansException beansException) {
            beansException.printStackTrace();
        }
    }
}
