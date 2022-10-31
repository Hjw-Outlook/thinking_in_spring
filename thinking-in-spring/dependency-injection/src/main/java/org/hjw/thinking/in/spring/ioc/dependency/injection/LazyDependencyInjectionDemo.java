package org.hjw.thinking.in.spring.ioc.dependency.injection;

import org.hjw.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;

/**
 * @ClassName QualifierDependencyInjectionDemo
 * @Description 基于 {@link ObjectProvider} 注入实现延迟查找
 * @see ObjectProvider
 * @Author H_jw
 * @Date 2022-10-31 0031 下午 04:01
 * @Version 1.0
 */
public class LazyDependencyInjectionDemo {

    @Autowired
    private User user; // 实时查找

    @Autowired
    private ObjectProvider<User> userObjectProvider; // 延时查找

    @Autowired
    private ObjectFactory<Set<User>> usersObjectFactory;

//    @Bean
//    @Qualifier
//    public User user1() {
//        return createUser(3L);
//    }
//
//    @Bean
//    @Qualifier
//    public User user2() {
//        return createUser(4L);
//    }
//
//    private static User createUser(Long id) {
//        User user = new User();
//        user.setId(id);
//        return user;
//    }

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 把当前类作为配置类（Configuration Class）
        applicationContext.register(LazyDependencyInjectionDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResource = "classpath:/META-INF/dependency-lookup-context.xml";
        // 注册并加载bean
        reader.loadBeanDefinitions(xmlResource);

        // 启动容器
        applicationContext.refresh();

        LazyDependencyInjectionDemo demo = applicationContext.getBean(LazyDependencyInjectionDemo.class);
        // 期待输出 superUser
        System.out.println(demo.user);
        System.out.println("======================================================");
        // 期待输出 superUser
        System.out.println(demo.userObjectProvider.getObject()); // 继承ObjectFactory
        System.out.println("======================================================");
        // 期待输出 superUser，user
        demo.userObjectProvider.forEach(System.out::println);
        System.out.println("======================================================");
        // 期待输出 superUser，user
        System.out.println(demo.usersObjectFactory.getObject());


        // 关闭应用上下文
        applicationContext.close();
    }
}
