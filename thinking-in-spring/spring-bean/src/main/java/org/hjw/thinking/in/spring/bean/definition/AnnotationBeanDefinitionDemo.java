package org.hjw.thinking.in.spring.bean.definition;

import org.hjw.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @ClassName AnnotationBeanDefinitionDemo
 * @Description 注解 BeanDefinition 示例
 * @Author H_jw
 * @Date 2022-09-30 0030 下午 03:16
 * @Version 1.0
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 把当前类作为配置类（Configuration Class）
        applicationContext.register(AnnotationBeanDefinitionDemo.class);

        // 1. 通过 定义bean 名称方式注册到spring容器中
        registerUserBeanDefinition(applicationContext, "outlook-user");
        // 2. 通过 非定义bean 名称方式注册到spring容器中
        registerUserBeanDefinition(applicationContext, null);

        // 启动容器
        applicationContext.refresh();
        // 按照类型依赖查找
        System.out.println("获取config 中所有的Beans ：" + applicationContext.getBeansOfType(Config.class));
        System.out.println("获取user 中所有的Beans ：" + applicationContext.getBeansOfType(User.class));

        // 关闭应用上下文
        applicationContext.close();
    }

    private static void registerUserBeanDefinition(BeanDefinitionRegistry registry , String beanName) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("id", 1).addPropertyValue("name", "hjw");

        if (StringUtils.hasText(beanName)) {
            registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
            return;
        }

        BeanDefinitionReaderUtils.registerWithGeneratedName(builder.getBeanDefinition(), registry);
    }

    // 2. 通过 @Component 方式定义
    @Component // 定义当前类作为 Spring Bean（组件）
    public static class Config {

        // 1. 通过 @Bean 方式定义
        @Bean(name = {"user", "hjw-user"}) // 通过Java注解方式定义 Bean
        public User createUser() {
            User user = new User();
            user.setId(1L);
            user.setName("hjw");
            return user;
        }

    }

}
