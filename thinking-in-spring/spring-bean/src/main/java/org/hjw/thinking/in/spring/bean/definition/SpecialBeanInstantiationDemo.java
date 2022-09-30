package org.hjw.thinking.in.spring.bean.definition;

import org.hjw.thinking.in.spring.bean.factory.DefaultUserFactory;
import org.hjw.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @ClassName BeanInstantiationDemo
 * @Description Bean 实例化示例
 * @Author H_jw
 * @Date 2022-09-30 0030 下午 04:19
 * @Version 1.0
 */
public class SpecialBeanInstantiationDemo {

    public static void main(String[] args) {
        // 配置 xml 配置文件
        // 启动 spring 应用上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-Instantiation-context.xml");
        // 通过 ApplicationContext 获取 AutowireCapableBeanFactory
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();

        ServiceLoader<UserFactory> serviceLoader = beanFactory.getBean("userServiceLoaderFactoryBean", ServiceLoader.class);
        displayUser(serviceLoader);

        // 通过 AutowireCapableBeanFactory 创建 UserFactory 对象
        UserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
        System.out.println(userFactory.createUser());
//        demoServiceLoader();
    }

    private static void demoServiceLoader() {
        ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displayUser(serviceLoader);
    }

    private static void displayUser(ServiceLoader<UserFactory> serviceLoader) {
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactory userFactory = iterator.next();
            System.out.println(userFactory.createUser());
        }
    }


}
