package org.hjw.strategy;

/**
 * @PackageClassName: org.hjw.strategy.CatWeightComparator
 * @Description: TODO
 * @Author: JerryH
 * @Date: 2023-07-11, 0011 下午 04:05
 */
public class CatWeightComparator implements Comparator<Cat>{

    @Override
    public int compareTo(Cat o1, Cat o2) {
        if (o1.getWeight() < o2.getWeight()) return -1;
        else if (o1.getWeight() > o2.getWeight()) return 1;
        else return 0;
    }

}
