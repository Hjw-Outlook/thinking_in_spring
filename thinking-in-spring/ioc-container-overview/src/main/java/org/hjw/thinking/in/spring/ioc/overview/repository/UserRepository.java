package org.hjw.thinking.in.spring.ioc.overview.repository;

import org.hjw.thinking.in.spring.ioc.overview.domain.User;

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

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + users +
                '}';
    }
}
