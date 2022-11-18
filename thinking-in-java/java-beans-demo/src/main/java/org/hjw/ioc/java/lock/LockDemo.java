package org.hjw.ioc.java.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockDemo
 * @Description TODO
 * @Author H_jw
 * @Date 2022-08-15 0015 下午 06:02
 * @Version 1.0
 */
public class LockDemo {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        System.out.println(lock.isFair());
    }
}
