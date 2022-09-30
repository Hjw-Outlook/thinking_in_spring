package org.hjw.thinking.in.spring.bean.definition;

import org.hjw.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName BeanInstantiationDemo
 * @Description Bean 实例化示例
 * @Author H_jw
 * @Date 2022-09-30 0030 下午 04:19
 * @Version 1.0
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {
        // 配置 xml 配置文件
        // 启动 spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-Instantiation-context.xml");
        User user = beanFactory.getBean("user-by-static-method", User.class);
        System.out.println(user);
        User instantiationUser = beanFactory.getBean("user-by-instantiation-method", User.class);
        System.out.println(instantiationUser);
        User userFactoryBean = beanFactory.getBean("user-by-factory-bean", User.class);
        System.out.println(userFactoryBean);

        System.out.println(instantiationUser == user);
        System.out.println(instantiationUser == userFactoryBean);

    }
}
