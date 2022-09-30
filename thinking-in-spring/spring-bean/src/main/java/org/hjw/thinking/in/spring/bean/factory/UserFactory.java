package org.hjw.thinking.in.spring.bean.factory;

import org.hjw.thinking.in.spring.ioc.overview.domain.User;

/**
 * @interfaceName UserFactory
 * @Description {@link User} 抽象工厂
 * @Author H_jw
 * @Date 2022-09-30 0030 下午 04:30
 * @Version 1.0
 */
public interface UserFactory {

    default User createUser() {
        return User.createUser();
    }
}
