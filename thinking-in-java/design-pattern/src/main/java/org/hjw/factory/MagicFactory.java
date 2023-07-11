package org.hjw.factory;

/**
 * @PackageClassName: org.hjw.factory.MagicFactory
 * @Description: TODO
 * @Author: JerryH
 * @Date: 2023-07-11, 0011 下午 10:42
 */
public class MagicFactory extends AbstractFactory{
    @Override
    AbstractFood createFood() {
        // before process
        return new Mushroom();
    }

    @Override
    AbstractVehicle createVehicle() {
        // before process
        return new Broom();
    }

    @Override
    AbstractWeapon createWeapon() {
        // before process
        return new MagicStick();
    }
}
