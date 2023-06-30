package org.hjw.threadsequence;

import java.util.concurrent.Semaphore;

/**
 * @PackageClassName: org.hjw.threadsequence.ThreadSemaphoreHandlerDemo
 * @Description: 使用信号量进行管控线程的顺序 {@link Semaphore}
 * @Author: JerryH
 * @Date: 2023-06-30, 0030 上午 10:34
 */
public class ThreadSemaphoreHandlerDemo {

    private static final int taskExecuteCount = 10;

    public static void main(String[] args) throws InterruptedException {

        // 信号量
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < taskExecuteCount; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire(3);
                    System.out.printf("线程名称：%S，已经执行完毕！\n", Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release(3);
                }
            }).start();
        }


    }
}
