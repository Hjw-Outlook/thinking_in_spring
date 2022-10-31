package org.hjw.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName AnnotationDependencySetterInjectionDemo
 * @Description 基于 {@link Aware} 接口回调 注入示例演示
 * @Author H_jw
 * @Date 2022-10-29 0029 下午 05:07
 * @Version 1.0
 */
public class AwareInterfaceDependencyInjectionDemo implements BeanFactoryAware, ApplicationContextAware {

    // 便于演示做成 static
    private static BeanFactory beanFactory;
    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 把当前类作为配置类（Configuration Class）
        context.register(AwareInterfaceDependencyInjectionDemo.class);
        // 启动容器
        context.refresh();

        System.out.println(beanFactory == context.getBeanFactory());
        System.out.println(applicationContext == context);

        // 关闭应用上下文
        context.close();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        AwareInterfaceDependencyInjectionDemo.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AwareInterfaceDependencyInjectionDemo.applicationContext = applicationContext;
    }
}
