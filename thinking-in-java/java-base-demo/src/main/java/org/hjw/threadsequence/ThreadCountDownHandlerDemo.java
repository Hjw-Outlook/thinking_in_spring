package org.hjw.threadsequence;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @PackageClassName: org.hjw.threadsequence.ThreadCountDownHandlerDemo
 * @Description: 使用 {@link java.util.concurrent.CountDownLatch} 保证线程执行的顺序性，注意：传入倒数的参数必须是与执行的线程数一致
 * @Author: JerryH
 * @Date: 2023-06-30, 0030 上午 10:10
 */
public class ThreadCountDownHandlerDemo {

    private static volatile int countNum = 0;

    private static final Object obj = new Object();

    private synchronized static void runCount() {
        for (int j = 0; j < 1000; j++) {
            countNum++;
        }
    }

    private static final int threadCoreSize = 10;

    private static final int taskExecuteCount = 20;

    public static void main(String[] args) throws InterruptedException {
        // 创建线程池进行执行多次修改一个共享变量
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(threadCoreSize, threadCoreSize, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        CountDownLatch count = new CountDownLatch(taskExecuteCount);
        for (int i = 0; i < taskExecuteCount; i++) {
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

        // 等待所有线程执行完毕
        count.await();

        System.out.println(countNum);

        // 关闭线程池
        threadPoolExecutor.shutdown();
    }
}
