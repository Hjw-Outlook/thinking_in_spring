package org.hjw.strategy;

/**
 * @PackageClassName: org.hjw.strategy.CatHeightComparator
 * @Description: TODO
 * @Author: JerryH
 * @Date: 2023-07-11, 0011 下午 08:44
 */
public class CatHeightComparator implements Comparator<Cat>{
    @Override
    public int compareTo(Cat o1, Cat o2) {
        if (o1.getHeight() < o2.getHeight()) return -1;
        else if (o1.getHeight() > o2.getHeight()) return 1;
        return 0;
    }
}
