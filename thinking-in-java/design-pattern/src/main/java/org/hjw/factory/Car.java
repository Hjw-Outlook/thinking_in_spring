package org.hjw.factory;

/**
 * @PackageClassName: org.hjw.factory.Car
 * @Description: TODO
 * @Author: JerryH
 * @Date: 2023-07-11, 0011 下午 10:15
 */
public class Car extends AbstractVehicle {

    @Override
    public void go() {
        System.out.println("car.drive()....");
    }
}
