package org.hjw.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @PACKAGE_NAME: org.hjw.thinking.in.spring.dependency.lookup
 * @DESCRIPTION: 层次性依赖查找 {@link HierarchicalBeanFactory }
 * @NAME: hjw_outlook
 * @DATE: 2022-10-16 下午 05:30
 */
public class HierarchicalDependencyLookUpDemo {

    public static void main(String[] args) {
        // 创建容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 获取 HierarchicalBeanFactory <- ConfigurableBeanFactory <- ConfigurableListableBeanFactory
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
//        System.out.println("获取父类 BeanFactory : " + beanFactory.getParentBeanFactory());

        ConfigurableListableBeanFactory parentBeanFactory = createParentBeanFactory();
        beanFactory.setParentBeanFactory(parentBeanFactory);
//        System.out.println("获取父类 BeanFactory : " + beanFactory.getParentBeanFactory());

        displayContainsLocalBean(beanFactory, "user");
        displayContainsLocalBean(parentBeanFactory, "user");

        displayContainsBean(beanFactory, "user");
        displayContainsBean(parentBeanFactory, "user");

        // 把当前类作为配置类
        applicationContext.register(HierarchicalDependencyLookUpDemo.class);
        // 启动容器
        applicationContext.refresh();
        // 关闭应用上下文
        applicationContext.close();
    }

    private static void displayContainsBean(HierarchicalBeanFactory hierarchicalBeanFactory, String beanName) {
        System.out.printf("当前beanFactory：%s，是否包含beanName：%s，结果为：%s\n", hierarchicalBeanFactory, beanName, containsBean(hierarchicalBeanFactory, beanName));
    }

    private static boolean containsBean(HierarchicalBeanFactory hierarchicalBeanFactory, String beanName) {
        BeanFactory parentBeanFactory = hierarchicalBeanFactory.getParentBeanFactory();
        if (parentBeanFactory instanceof HierarchicalBeanFactory) {
            HierarchicalBeanFactory parentHierarchicalBeanFactory = ((HierarchicalBeanFactory) parentBeanFactory);
            if (parentHierarchicalBeanFactory.containsLocalBean(beanName)) {
                return true;
            }
            containsBean(parentHierarchicalBeanFactory, beanName);
        }
        return hierarchicalBeanFactory.containsBean(beanName);
    }

    private static void displayContainsLocalBean(HierarchicalBeanFactory hierarchicalBeanFactory, String beanName) {
        System.out.printf("当前beanFactory：%s，是否包含local beanName：%s，结果为：%s\n", hierarchicalBeanFactory, beanName, hierarchicalBeanFactory.containsLocalBean(beanName));
    }

    private static ConfigurableListableBeanFactory createParentBeanFactory() {
        // 配置XML配置文件
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");
        return applicationContext.getBeanFactory();
    }
}
