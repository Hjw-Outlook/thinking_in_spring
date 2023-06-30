package org.hjw.threadsequence;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @PackageClassName: org.hjw.threadsequence.ThreadSinglePoolHandlerDemo
 * @Description: {@link Executors}中使用单线程的线程池执行
 * @Author: JerryH
 * @Date: 2023-06-30, 0030 上午 10:30
 */
public class ThreadSinglePoolHandlerDemo {

    private static volatile int countNum = 0;

    private static final Object obj = new Object();

    private synchronized static void runCount() {
        for (int j = 0; j < 1000; j++) {
            countNum++;
        }
    }

    private static final int taskExecuteCount = 20;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        CountDownLatch count = new CountDownLatch(taskExecuteCount);
        for (int i = 0; i < taskExecuteCount; i++) {
            executorService.execute(() -> {
                //synchronized (VolatileAtomHandlerDemo.class) {
                //synchronized (obj) {
                //    for (int j = 0; j < 1000; j++) {
                //        countNum ++;
                //    }
                //}
                for (int j = 0; j < 1000; j++) {
                    countNum++;
                }
                //runCount();
                System.out.printf("线程名称：%S，已经执行完毕！\n", Thread.currentThread().getName());
                count.countDown();
            });
        }

        // 等待所有线程执行完毕
        count.await();

        System.out.println(countNum);

        // 关闭线程池
        executorService.shutdown();
    }
}
