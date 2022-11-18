package org.hjw.ioc.java.thread;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName thread.ThreadTimeUnitDemo
 * @Description TODO
 * @Author H_jw
 * @Date 2022-08-12 0012 下午 05:26
 * @Version 1.0
 */
public class ThreadTimeUnitDemo {

    public static void main(String[] args) {

        System.out.println(TimeUnit.SECONDS.toSeconds(100));
        System.out.println(TimeUnit.HOURS.toSeconds(1));
    }
}
