package org.hjw.thinking.in.spring.ioc.overview.dependency.injection;

import org.hjw.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @ClassName DependencyLookupDemo
 * @Description 依赖查找示例： 名称 ，类型
 * @Author H_jw
 * @Date 2022-09-26 0026 下午 02:12
 * @Version 1.0
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        // 配置XML配置文件
        // 启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");
        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");
        // 依赖来源一：自定义bean
        System.out.println("实时查找 ：user = " + userRepository.getUsers());

        // 依赖注入
        // 依赖来源二：容器内建依赖
        System.out.println(userRepository.getBeanFactory());

        // 内建ApplicationContext
        ObjectFactory<ApplicationContext> objectFactory = userRepository.getObjectFactory();
        System.out.println(objectFactory.getObject());

//        ObjectFactory<User> userObjectFactory = userRepository.getUserObjectFactory();
//        System.out.println(userObjectFactory.getObject());

        System.out.println(beanFactory);

        System.out.println(beanFactory == objectFactory.getObject());

        // 依赖查找不到 BeanFactory（错误代码）
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        // 依赖来源三：容器内建bean对象
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println(environment);
    }


}
