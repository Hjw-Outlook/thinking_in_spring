package org.hjw.thinking.in.spring.ioc.overview.container;

import org.hjw.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @ClassName BeanFactoryAsIocContainer
 * {@link  BeanFactory} 作为Ioc容器
 * @Author H_jw
 * @Date 2022-09-29 0029 下午 05:34
 * @Version 1.0
 */
public class BeanFactoryAsIocContainer {

    public static void main(String[] args) {
        // 创建容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 读取配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        int loadBeansDefinitionCount = reader.loadBeanDefinitions(location);

        System.out.println("容器加载定义bean的个数 ：" + loadBeansDefinitionCount);
        // 依赖查找
        lookupCollectionByType(beanFactory);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("实时类型查找所有User对象：userMap = " + userMap);
        }
    }
}
