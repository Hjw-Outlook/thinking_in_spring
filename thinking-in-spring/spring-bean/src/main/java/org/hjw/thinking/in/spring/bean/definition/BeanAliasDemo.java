package org.hjw.thinking.in.spring.bean.definition;

import org.hjw.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName BeanAliasDemo
 * @Description Bean 别名示例
 * @Author H_jw
 * @Date 2022-09-30 0030 下午 02:57
 * @Version 1.0
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        // 配置 xml 配置文件
        // 启动 spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");
        // 通过别名 hjw-user 获取曾用名 user 的 bean
        User user = beanFactory.getBean("user", User.class);
        User hjwUser = beanFactory.getBean("hjw-user", User.class);
        System.out.println("user 是否与 hjw-user 相同 ：" + (user == hjwUser));

    }
}
