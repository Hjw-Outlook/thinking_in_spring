package org.hjw.thinking.in.spring.ioc.dependency.injection;

import org.hjw.thinking.in.spring.ioc.overview.domain.SuperUser;
import org.hjw.thinking.in.spring.ioc.overview.domain.User;

/**
 * @ClassName UserHolder
 * @Description {@link User} holder 类
 * @Author H_jw
 * @Date 2022-10-29 0029 下午 05:13
 * @Version 1.0
 */
public class UserHolder {

    private User user;

    private SuperUser superUser;

    private String holderName;

    public UserHolder() {
    }

    public UserHolder(User user) {
        this.user = user;
    }
    public UserHolder(User user, String holderName) {
        this.user = user;
        this.holderName = holderName;
    }

    public UserHolder(User user, SuperUser superUser, String holderName) {
        this.user = user;
        this.superUser = superUser;
        this.holderName = holderName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                ", superUser=" + superUser +
                ", holderName='" + holderName + '\'' +
                '}';
    }
}
