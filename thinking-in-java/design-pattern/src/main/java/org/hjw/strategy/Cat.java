package org.hjw.strategy;

/**
 * @PackageClassName: org.hjw.strategy.Cat
 * @Description: TODO
 * @Author: JerryH
 * @Date: 2023-07-11, 0011 下午 03:54
 */
public class Cat {

    private Integer weight;

    private Integer height;

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Cat(Integer weight, Integer height, Integer age) {
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public Cat(Integer weight, Integer height) {
        this.weight = weight;
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                ", age=" + age +
                '}';
    }
}
