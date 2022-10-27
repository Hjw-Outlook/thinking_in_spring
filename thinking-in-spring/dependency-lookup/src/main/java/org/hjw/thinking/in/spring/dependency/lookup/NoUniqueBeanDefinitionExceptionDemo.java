package org.hjw.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName NoUniqueBeanDefinitionExceptionDemo
 * @Description {@link NoUniqueBeanDefinitionException} 示例
 * @Author H_jw
 * @Date 2022-10-27 0027 下午 04:18
 * @Version 1.0
 */
public class NoUniqueBeanDefinitionExceptionDemo {

    public static void main(String[] args) {
        // 创建应用上下文
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类注册为bean
        applicationContext.register(NoUniqueBeanDefinitionExceptionDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        // 进行依赖查找
        try {
            applicationContext.getBean(String.class);
        } catch (NoUniqueBeanDefinitionException e) {
            System.out.printf("当前上下文存在 %d个bean，类型是 %s，原因是 %s \n",
                    e.getNumberOfBeansFound(),
                    e.getBeanType(),
                    e.getMessage());
        }


        // 关闭应用上下文
        applicationContext.stop();
    }

    @Bean
    public String bean1() {
        return "1";
    }

    @Bean
    public String bean2() {
        return "2";
    }

    @Bean
    public String bean3() {
        return "3";
    }
}
