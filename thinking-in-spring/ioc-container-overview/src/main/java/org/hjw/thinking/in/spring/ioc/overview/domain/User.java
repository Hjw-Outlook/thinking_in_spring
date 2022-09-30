package org.hjw.thinking.in.spring.ioc.overview.domain;

/**
 * @ClassName User
 * @Description 用户类
 * @Author H_jw
 * @Date 2022-09-26 0026 下午 02:17
 * @Version 1.0
 */
public class User {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("hjw");
        return user;
    }
}
