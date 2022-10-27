package org.hjw.thinking.in.spring.dependency.lookup;

import org.hjw.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

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
        // 延迟依赖查找
        lookupByObjectProvider(applicationContext);
        lookupIfAvailable(applicationContext);
        lookupStreamOps(applicationContext);

        // 关闭应用上下文
        applicationContext.close();
    }

    private static void lookupStreamOps(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> stringObjectProvider = applicationContext.getBeanProvider(String.class);
//        for (String string : stringObjectProvider) {
//            System.out.println(string);
//        }
        // stream -> method reference
//        stringObjectProvider.stream().forEach(System.out::println);

        stringObjectProvider.forEach(System.out::println);
    }

    private static void lookupIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        User user = userObjectProvider.getIfAvailable(User::createUser);
        System.out.println("获取 user 对象：" + user);
    }

    @Bean
    @Primary
    public String helloWorld() {
        return "hello, world";
    }

    @Bean
    public String message() {
        return "message";
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());

    }

}
