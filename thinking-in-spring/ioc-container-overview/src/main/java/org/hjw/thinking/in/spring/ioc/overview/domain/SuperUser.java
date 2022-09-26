package org.hjw.thinking.in.spring.ioc.overview.domain;

import org.hjw.thinking.in.spring.ioc.overview.annotation.Super;

/**
 * @ClassName SuperUser
 * @Description 超级用户
 * @Author H_jw
 * @Date 2022-09-26 0026 下午 02:47
 * @Version 1.0
 */
@Super
public class SuperUser extends User{

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
