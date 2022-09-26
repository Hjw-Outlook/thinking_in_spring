package org.hjw.thinking.in.spring.ioc.overview.dependency.injection;

import org.hjw.thinking.in.spring.ioc.overview.domain.User;
import org.hjw.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        System.out.println("实时查找 ：user = " + userRepository);
    }


}
