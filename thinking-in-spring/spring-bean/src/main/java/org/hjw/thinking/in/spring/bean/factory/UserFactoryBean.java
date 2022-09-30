package org.hjw.thinking.in.spring.bean.factory;

import org.hjw.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName UserFactoryBean
 * @Description {@link User} 类的 {@link FactoryBean} 方法实现
 * @Author H_jw
 * @Date 2022-09-30 0030 下午 04:45
 * @Version 1.0
 */
public class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
