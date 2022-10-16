package org.hjw.thinking.in.spring.bean.definition;

import org.hjw.thinking.in.spring.bean.factory.DefaultUserFactory;
import org.hjw.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @PACKAGE_NAME: org.hjw.thinking.in.spring.bean.definition
 * @DESCRIPTION: bean 初始化 demo
 * @NAME: hjw_outlook
 * @DATE: 2022-10-09 下午 04:13
 */
public class BeanInitializationDemo {

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 把当前类作为配置类（Configuration Class）
        applicationContext.register(BeanInitializationDemo.class);
        // 启动容器
        applicationContext.refresh();
        // 非延迟初始化在spring 应用上下文启动完成后进行被初始化
        System.out.println("spring 应用上下文已启动。。。。。");

        // 按照类型依赖查找
        System.out.println("UserFactory 中所有的Beans ：" + applicationContext.getBeansOfType(UserFactory.class));

        // 关闭应用上下文
        applicationContext.close();

        System.out.println("spring 应用上下文已关闭。。。。。");
    }


    @Bean(initMethod = "initUserFactory", destroyMethod = "doPreDestroy")
    @Lazy
    public UserFactory createUser() {
        return new DefaultUserFactory();
    }
}
