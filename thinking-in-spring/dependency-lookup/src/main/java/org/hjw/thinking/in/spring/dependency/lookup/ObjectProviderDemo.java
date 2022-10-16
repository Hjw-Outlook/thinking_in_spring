package org.hjw.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @PACKAGE_NAME: org.hjw.thinking.in.spring.dependency.lookup
 * @DESCRIPTION: 通过 {@link ObjectProvider} 进行依赖查找
 * @NAME: hjw_outlook
 * @DATE: 2022-10-16 下午 03:02
 */
public class ObjectProviderDemo {

    public static void main(String[] args) {
        // 创建容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 把当前类作为配置类
        applicationContext.register(ObjectProviderDemo.class);
        // 启动容器
        applicationContext.refresh();
        // 依赖查找
        lookupByObjectProvider(applicationContext);
        // 关闭应用上下文
        applicationContext.close();
    }

    @Bean
    public String helloWorld() {
        return "hello, world";
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());

    }

}
