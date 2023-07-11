package org.hjw.strategy;

import java.util.Arrays;

/**
 * @PackageClassName: org.hjw.strategy.StrategyMain
 * @Description: 策略模式测试类，相当于是if 分支的处理或者switch分支的处理
 * @Author: JerryH
 * @Date: 2023-07-11, 0011 下午 03:48
 */
public class StrategyMain {

    public static void main(String[] args) {
        Cat[] cats = {new Cat(3, 5, 2), new Cat(1,1, 4), new Cat(5, 2, 1), new Cat(4,4, 5)};
        Sorter<Cat> sorter = new Sorter<>();
        System.out.println(Arrays.toString(sorter.sort(cats, new CatWeightComparator())));

        System.out.println(Arrays.toString(sorter.sort(cats, new CatHeightComparator())));

        System.out.println(Arrays.toString(sorter.sort(cats, (o1, o2) -> {
            if (o1.getAge() < o2.getAge()) return -1;
            else if (o1.getAge() > o2.getAge()) return 1;
            else return 0;
        })));

    }
}
