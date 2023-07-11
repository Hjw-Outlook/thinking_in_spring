package org.hjw.strategy;

/**
 * @PackageClassName: org.hjw.strategy.Soter
 * @Description: TODO
 * @Author: JerryH
 * @Date: 2023-07-11, 0011 下午 03:58
 */
public class Sorter<T> {

    public T[] sort(T[] oArr, Comparator<T> comparator) {
        // 1, 5, 3
        for (int i = 0; i < oArr.length; i++) {

            for (int j = i; j < oArr.length; j++) {
                // 取最小值
                T temp = comparator.compareTo(oArr[i], oArr[j]) < 0 ? oArr[i] : oArr[j];
                if (temp == oArr[i]) continue;
                oArr[j] = oArr[i];
                oArr[i] = temp;
            }

        }
        return oArr;
    }
}
