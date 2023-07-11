package org.hjw.factory;

/**
 * @PackageClassName: org.hjw.factory.FactoryMain
 * @Description: 工厂方法： 对扩展一个产品比较友好；抽象工厂：对扩展一个产品组比较友好
 * @Author: JerryH
 * @Date: 2023-07-11, 0011 下午 10:07
 */
public class FactoryMain {

    public static void main(String[] args) {
        AbstractFactory factory = new ModernFactory();
        factory.createVehicle().go();
        factory.createFood().taste();
        factory.createWeapon().shoot();
    }
}
