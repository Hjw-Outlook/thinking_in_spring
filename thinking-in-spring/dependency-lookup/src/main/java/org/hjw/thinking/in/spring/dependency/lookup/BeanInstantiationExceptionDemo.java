package org.hjw.thinking.in.spring.dependency.lookup;

import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName BeanInstantiationExceptionDemo
 * @Description {@link BeanInstantiationException} 实例化异常
 * @Author H_jw
 * @Date 2022-10-27 0027 下午 04:28
 * @Version 1.0
 */
public class BeanInstantiationExceptionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 将 CharSquare 接口作为 BeanDefinition 注册到容器中
        BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(CharSequence.class).getBeanDefinition();
        applicationContext.registerBeanDefinition("errorBean", beanDefinition);

        applicationContext.refresh();

        applicationContext.stop();
    }
}
