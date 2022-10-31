package org.hjw.thinking.in.spring.ioc.dependency.injection;

import org.hjw.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * @ClassName AnnotationDependencySetterInjectionDemo
 * @Description 基于 注解 方法 注入示例演示
 * @Author H_jw
 * @Date 2022-10-29 0029 下午 05:07
 * @Version 1.0
 */
public class AnnotationDependencyMethodInjectionDemo {

    private UserHolder userHolder;
    private UserHolder userHolder2;

    @Autowired
    private void init1(UserHolder userHolder){
        this.userHolder = userHolder;
    }
//    public void init1(UserHolder userHolder){
//        this.userHolder = userHolder;
//    }

    @Resource
    private void init2(UserHolder userHolder) {
        this.userHolder2 = userHolder;
    }
//    public void init2(UserHolder userHolder) {
//        this.userHolder2 = userHolder;
//    }

    @Bean
    public UserHolder userHolder(User user) {
        return new UserHolder(user);
    }

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 把当前类作为配置类（Configuration Class）
        applicationContext.register(AnnotationDependencyMethodInjectionDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResource = "classpath:/META-INF/dependency-lookup-context.xml";
        // 注册并加载bean
        reader.loadBeanDefinitions(xmlResource);

        // 启动容器
        applicationContext.refresh();

        AnnotationDependencyMethodInjectionDemo demo = applicationContext.getBean(AnnotationDependencyMethodInjectionDemo.class);

        System.out.println(demo.userHolder);
        System.out.println(demo.userHolder2);
        System.out.println(demo.userHolder == demo.userHolder2);


        // 关闭应用上下文
        applicationContext.close();
    }

}
