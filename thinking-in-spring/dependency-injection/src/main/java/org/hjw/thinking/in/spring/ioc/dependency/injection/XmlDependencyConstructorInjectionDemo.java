package org.hjw.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @ClassName XmlDependencySetterInjectionDemo
 * @Description 基于 xml Constructor 注入示例演示
 * @Author H_jw
 * @Date 2022-10-29 0029 下午 05:07
 * @Version 1.0
 */
public class XmlDependencyConstructorInjectionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        String xmlResource = "classpath:/META-INF/dependency-constructor-injection.xml";
        // 注册并加载bean
        reader.loadBeanDefinitions(xmlResource);

        System.out.println(beanFactory.getBean(UserHolder.class));

    }
}
