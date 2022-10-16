package org.hjw.thinking.in.spring.bean.definition;

import org.hjw.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @PACKAGE_NAME: org.hjw.thinking.in.spring.bean.definition
 * @DESCRIPTION: GC 回收示例
 * @NAME: hjw_outlook
 * @DATE: 2022-10-09 下午 06:12
 */
public class BeanGarbageCollectionDemo {

    public static void main(String[] args) throws InterruptedException {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 把当前类作为配置类（Configuration Class）
        applicationContext.register(BeanInitializationDemo.class);
        // 启动容器
        applicationContext.refresh();
        // 非延迟初始化在spring 应用上下文启动完成后进行被初始化
        System.out.println("spring 应用上下文已启动。。。。。");

        // 按照类型依赖查找
        System.out.println("UserFactory 中所有的Beans ：" + applicationContext.getBeansOfType(UserFactory.class));

        // 关闭应用上下文
        applicationContext.close();

        System.out.println("spring 应用上下文已关闭。。。。。");
        Thread.sleep(5000L);
        System.gc();
        Thread.sleep(5000L);
    }
}
