package org.hjw.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @ClassName AutowiringDependencySetterInjectionDemo
 * @Description 基于 自动绑定（"byType"，"byName"） setter 注入示例演示
 * @Author H_jw
 * @Date 2022-10-29 0029 下午 05:07
 * @Version 1.0
 */
public class AutowiringDependencySetterInjectionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        String xmlResource = "classpath:/META-INF/autowiring-dependency-setter-injection.xml";
        // 注册并加载bean
        reader.loadBeanDefinitions(xmlResource);

        System.out.println(beanFactory.getBean(UserHolder.class));

    }
}
