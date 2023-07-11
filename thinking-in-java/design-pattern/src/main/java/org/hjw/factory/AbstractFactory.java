package org.hjw.factory;

/**
 * @PackageClassName: org.hjw.factory.AbstractFactory
 * @Description: TODO
 * @Author: JerryH
 * @Date: 2023-07-11, 0011 下午 10:28
 */
public abstract class AbstractFactory {

    abstract AbstractFood createFood();

    abstract AbstractVehicle createVehicle();

    abstract AbstractWeapon createWeapon();
}
