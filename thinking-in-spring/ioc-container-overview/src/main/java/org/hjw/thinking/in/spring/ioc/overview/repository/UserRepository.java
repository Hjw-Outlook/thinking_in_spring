package org.hjw.thinking.in.spring.ioc.overview.repository;

import org.hjw.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @ClassName UserRepository
 * @Description 用户信息仓库
 * @Author H_jw
 * @Date 2022-09-26 0026 下午 07:08
 * @Version 1.0
 */
public class UserRepository {

    private Collection<User> users;

    private ObjectFactory<ApplicationContext> objectFactory;

//    private ObjectFactory<User> userObjectFactory;

    private BeanFactory beanFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }


//    public ObjectFactory<User> getUserObjectFactory() {
//        return userObjectFactory;
//    }
//
//    public void setUserObjectFactory(ObjectFactory<User> userObjectFactory) {
//        this.userObjectFactory = userObjectFactory;
//    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + users +
                '}';
    }
}
