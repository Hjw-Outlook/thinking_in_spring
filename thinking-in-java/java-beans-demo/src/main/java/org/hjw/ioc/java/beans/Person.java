package org.hjw.ioc.java.beans;

/**
 * @ClassName Person
 * @Description setter（writable）/getter（readable） 方法
 * @Author H_jw
 * @Date 2022-08-22 0022 上午 11:51
 * @Version 1.0
 */
public class Person {

    private String name;// property

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
