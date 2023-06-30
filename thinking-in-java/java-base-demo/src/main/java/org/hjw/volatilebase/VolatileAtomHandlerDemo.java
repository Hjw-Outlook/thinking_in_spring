package org.hjw.volatilebase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @PackageClassName: org.hjw.volatilebase.VolatileAtomHandlerDemo
 * @Description: volatile不能保证数据原子性，需要进行加锁配合
 * @Author: JerryH
 * @Date: 2023-06-29, 0029 下午 02:55
 */
public class VolatileAtomHandlerDemo {

    private static volatile int countNum = 0;

    private static final Object obj = new Object();

    private synchronized static void runCount() {
        for (int j = 0; j < 1000; j++) {
            countNum++;
        }
    }

    private static final int threadCoreSize = 10;

    public static void main(String[] args) throws InterruptedException {
        // 创建线程池进行执行多次修改一个共享变量
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(threadCoreSize, threadCoreSize, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        CountDownLatch count = new CountDownLatch(threadPoolExecutor.getCorePoolSize());

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                //synchronized (VolatileAtomHandlerDemo.class) {
                //synchronized (obj) {
                //    for (int j = 0; j < 1000; j++) {
                //        countNum ++;
                //    }
                //}
                runCount();
                System.out.printf("线程名称：%S，已经执行完毕！\n", Thread.currentThread().getName());
                count.countDown();
            });
        }

        count.await();

        System.out.println(countNum);

        // 关闭线程池
        threadPoolExecutor.shutdown();
    }
}
