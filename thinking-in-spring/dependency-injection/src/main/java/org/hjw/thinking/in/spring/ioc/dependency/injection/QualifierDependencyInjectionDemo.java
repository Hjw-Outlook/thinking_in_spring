package org.hjw.thinking.in.spring.ioc.dependency.injection;

import org.hjw.thinking.in.spring.ioc.dependency.injection.annotation.UserGroup;
import org.hjw.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName QualifierDependencyInjectionDemo
 * @Description 基于 {@link Qualifier} 注解注入
 * @see Qualifier @LoadBalanced
 * @Author H_jw
 * @Date 2022-10-31 0031 下午 04:01
 * @Version 1.0
 */
public class QualifierDependencyInjectionDemo {

    @Autowired // super -> superUser(primary = true)
    private User user;

    @Autowired
    @Qualifier("user") // 指定 Bean 名称或ID
    private User nameUser;

    @Autowired
    private Collection<User> allUsers; // 使用了 Qualifier 进行分组了之后，无法注入 user1 和 user2，只会注入 user 和 superUser

    @Autowired
    @Qualifier
    private List<User> qualifierUsers; // 用 Qualifier 进行分组，期待注入 user1 + user2 -> user1 ~ user4

    @Autowired
    @UserGroup
    private List<User> groupedUsers; // 用 UserGroup 进行分组，期待注入 user3 + user4

    @Bean
    @Qualifier
    public User user1() {
        return createUser(3L);
    }

    @Bean
    @Qualifier
    public User user2() {
        return createUser(4L);
    }

    @Bean
    @UserGroup
    public User user3() {
        return createUser(5L);
    }

    @Bean
    @UserGroup
    public User user4() {
        return createUser(6L);
    }

    private static User createUser(Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 把当前类作为配置类（Configuration Class）
        applicationContext.register(QualifierDependencyInjectionDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResource = "classpath:/META-INF/dependency-lookup-context.xml";
        // 注册并加载bean
        reader.loadBeanDefinitions(xmlResource);

        // 启动容器
        applicationContext.refresh();

        QualifierDependencyInjectionDemo demo = applicationContext.getBean(QualifierDependencyInjectionDemo.class);
        System.out.println(demo.user);
        System.out.println(demo.nameUser);
        System.out.println(demo.allUsers);
        System.out.println(demo.qualifierUsers);
        System.out.println(demo.groupedUsers);

        // 关闭应用上下文
        applicationContext.close();
    }
}
