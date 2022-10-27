package org.hjw.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @ClassName BeanCreationExceptionDemo
 * @Description {@link BeanCreationException} 创建Bean异常示例
 * @Author H_jw
 * @Date 2022-10-27 0027 下午 04:25
 * @Version 1.0
 */
public class BeanCreationExceptionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Pojo.class).getBeanDefinition();
        applicationContext.registerBeanDefinition("errorBean", beanDefinition);

        applicationContext.refresh();


        applicationContext.stop();
    }

    static class Pojo implements InitializingBean {

        @PostConstruct
        public void init() throws Exception {
            throw new Exception("init() : On purpose....");
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            throw new Exception("InitializingBean() : On purpose....");
        }

    }
}
