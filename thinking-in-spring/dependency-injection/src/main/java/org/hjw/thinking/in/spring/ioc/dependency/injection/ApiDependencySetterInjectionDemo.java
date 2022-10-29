package org.hjw.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName ApiDependencySetterInjectionDemo
 * @Description 基于 spring Api setter 注入示例演示
 * @Author H_jw
 * @Date 2022-10-29 0029 下午 05:07
 * @Version 1.0
 */
public class ApiDependencySetterInjectionDemo {

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 生成UserHolder 的 BeanDefinition
        BeanDefinition userHolderBeanDefinition = createUserHolderBeanDefinition();
        // 注册 UserHolder 的 BeanDefinition
        applicationContext.registerBeanDefinition("userHolder", userHolderBeanDefinition);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResource = "classpath:/META-INF/dependency-lookup-context.xml";
        // 注册并加载bean
        reader.loadBeanDefinitions(xmlResource);

        // 启动容器
        applicationContext.refresh();

        System.out.println(applicationContext.getBean(UserHolder.class));

        // 关闭应用上下文
        applicationContext.close();
    }

    // 通过spring Api进行 注册BeanDefinition
    private static BeanDefinition createUserHolderBeanDefinition() {
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        definitionBuilder.addPropertyReference("user", "superUser");
        return definitionBuilder.getBeanDefinition();
    }

//    @Bean
//    public UserHolder userHolder(User user) { // superUser -> primary = true
//        UserHolder userHolder = new UserHolder();
//        userHolder.setUser(user);
//        return userHolder;
////        return new UserHolder(user);
//    }
}
