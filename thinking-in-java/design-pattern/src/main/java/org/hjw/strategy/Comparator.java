package org.hjw.strategy;

/**
 * @PackageClassName: org.hjw.strategy.Comparetor
 * @Description: 比较器
 * @Author: JerryH
 * @Date: 2023-07-11, 0011 下午 03:55
 */
@FunctionalInterface
public interface Comparator<T> {

    int compareTo(T o1, T o2);

    default void m() {}
}
