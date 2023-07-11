package org.hjw.factory;

/**
 * @PackageClassName: org.hjw.factory.Bread
 * @Description: TODO
 * @Author: JerryH
 * @Date: 2023-07-11, 0011 下午 10:17
 */
public class Bread extends AbstractFood {

    @Override
    public void taste() {
        System.out.println("Bread.taste()......");
    }
}
