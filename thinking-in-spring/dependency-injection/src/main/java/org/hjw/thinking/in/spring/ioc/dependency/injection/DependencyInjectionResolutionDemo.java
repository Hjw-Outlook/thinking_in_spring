package org.hjw.thinking.in.spring.ioc.dependency.injection;

import org.hjw.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * @ClassName QualifierDependencyInjectionDemo
 * @Description 基于 {@link DefaultListableBeanFactory} 中的
 * DefaultListableBeanFactory#resolveDependency(DependencyDescriptor, String, Set, TypeConverter) 进行依赖处理
 * @see DefaultListableBeanFactory
 * @Author H_jw
 * @Date 2022-10-31 0031 下午 04:01
 * @Version 1.0
 */
public class DependencyInjectionResolutionDemo {

    @Autowired
    @Lazy
    private User lazyUser;// superUser通过cglib提升的一个代理对象

    @Autowired
    private User user;
    // 依赖查找处理
    // DependencyDescriptor ->
    // 必须（required=true）
    // 实时（eager = true）
    // 通过类型 user.class 依赖查找
    // 字段名称 'user' 名称查找
    // 是否首要（primary = true）

    @Autowired
    private Map<String, User> userMap; // User + superUser

    @Autowired
    private Collection<User> userCollection;// User + superUser

    @Autowired
    private Optional<User> userOptional;// superUser

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 把当前类作为配置类（Configuration Class）
        applicationContext.register(DependencyInjectionResolutionDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResource = "classpath:/META-INF/dependency-lookup-context.xml";
        // 注册并加载bean
        reader.loadBeanDefinitions(xmlResource);

        // 启动容器
        applicationContext.refresh();

        DependencyInjectionResolutionDemo demo = applicationContext.getBean(DependencyInjectionResolutionDemo.class);
        // 期待输出 superUser
        System.out.println(demo.lazyUser);
        System.out.println("=======================================");
        System.out.println(demo.user);
        System.out.println("=======================================");
        System.out.println(demo.userMap);
        System.out.println("=======================================");
        System.out.println(demo.userCollection);
        System.out.println("=======================================");
        System.out.println(demo.userOptional);


        // 关闭应用上下文
        applicationContext.close();
    }
}
