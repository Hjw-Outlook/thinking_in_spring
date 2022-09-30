package org.hjw.thinking.in.spring.ioc.overview.container;

import org.hjw.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @ClassName AnnotationApplicationContextAsIocContainer
 * {@link AnnotationConfigApplicationContext} 作为Ioc容器
 * @Author H_jw
 * @Date 2022-09-29 0029 下午 05:40
 * @Version 1.0
 */
public class AnnotationApplicationContextAsIocContainer {

    public static void main(String[] args) {
        // 创建容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 把当前类作为配置类
        applicationContext.register(AnnotationApplicationContextAsIocContainer.class);
        // 启动容器
        applicationContext.refresh();
        // 依赖查找
        lookupCollectionByType(applicationContext);
        // 关闭应用上下文
        applicationContext.close();
    }

    @Bean
    public User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("hjw");
        return user;
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("实时类型查找所有User对象：userMap = " + userMap);
        }
    }
}
