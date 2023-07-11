package org.hjw.factory;

/**
 * @PackageClassName: org.hjw.factory.ModernFactory
 * @Description: TODO
 * @Author: JerryH
 * @Date: 2023-07-11, 0011 下午 10:40
 */
public class ModernFactory extends AbstractFactory{
    @Override
    AbstractFood createFood() {
        // before process
        return new Bread();
    }

    @Override
    AbstractVehicle createVehicle() {
        // before process
        return new Car();
    }

    @Override
    AbstractWeapon createWeapon() {
        // before process
        return new Ak47();
    }
}
