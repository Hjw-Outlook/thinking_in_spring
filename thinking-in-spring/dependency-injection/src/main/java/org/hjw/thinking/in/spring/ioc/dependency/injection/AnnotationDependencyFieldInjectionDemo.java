package org.hjw.thinking.in.spring.ioc.dependency.injection;

import org.hjw.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * @ClassName AnnotationDependencySetterInjectionDemo
 * @Description 基于 注解 字段 注入示例演示
 * @Author H_jw
 * @Date 2022-10-29 0029 下午 05:07
 * @Version 1.0
 */
public class AnnotationDependencyFieldInjectionDemo {

    @Autowired // 注入的字段中忽略 静态字段 ，具体详细：org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor
    private UserHolder userHolder;
//    private static UserHolder userHolder;

    @Resource
    private UserHolder userHolder2;
//    private static UserHolder userHolder2; //@Resource annotation is not supported on static fields

//    @Inject
//    private UserHolder userHolder3;

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 把当前类作为配置类（Configuration Class）
        applicationContext.register(AnnotationDependencyFieldInjectionDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResource = "classpath:/META-INF/dependency-lookup-context.xml";
        // 注册并加载bean
        reader.loadBeanDefinitions(xmlResource);

        // 启动容器
        applicationContext.refresh();

        AnnotationDependencyFieldInjectionDemo demo = applicationContext.getBean(AnnotationDependencyFieldInjectionDemo.class);

        System.out.println(demo.userHolder);
        System.out.println(demo.userHolder2);


        // 关闭应用上下文
        applicationContext.close();
    }

    @Bean
    public UserHolder userHolder(User user) {
        return new UserHolder(user);
    }
}
