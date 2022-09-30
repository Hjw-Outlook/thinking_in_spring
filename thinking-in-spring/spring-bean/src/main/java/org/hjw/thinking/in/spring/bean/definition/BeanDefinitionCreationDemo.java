package org.hjw.thinking.in.spring.bean.definition;

import org.hjw.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @ClassName BeanDefinitionCreationDemo
 * {@link BeanDefinition} BeanDefinition构建示例
 * @Author H_jw
 * @Date 2022-09-30 0030 上午 11:24
 * @Version 1.0
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {
        // 1.构建BeanDefinitionBuilder
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 设置用户属性
        beanDefinitionBuilder.addPropertyValue("id", 1).addPropertyValue("name", "hjw");
        // 获取BeanDefinition
//        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // BeanDefinition 并非最终状态，可以自定义修改

        // 2.通过AbstractBeanDefinition 或其派生类构建BeanDefinition
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        // 设置bean类型
        genericBeanDefinition.setBeanClass(User.class);
        // 通过 MutablePropertyValues 进行批量操作 propertyValues
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id", 1).add("name", "hjw");
        genericBeanDefinition.setPropertyValues(propertyValues);

    }
}
