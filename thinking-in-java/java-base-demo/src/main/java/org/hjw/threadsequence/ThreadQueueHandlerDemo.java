package org.hjw.threadsequence;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @PackageClassName: org.hjw.threadsequence.ThreadQueueHandlerDemo
 * @Description: 使用 {@link java.util.Queue} 阻塞队列进行保证线程执行的顺序性
 * @Author: JerryH
 * @Date: 2023-06-30, 0030 上午 10:17
 */
public class ThreadQueueHandlerDemo {

    private static final int threadCoreSize = 10;

    // 使用阻塞队列进行保证线程的顺序执行
    private static final LinkedBlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>(threadCoreSize);

    public static void main(String[] args) {
        // 创建线程池进行执行多次修改一个共享变量
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(threadCoreSize, threadCoreSize, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    int tempId = i;
                    taskQueue.offer(() -> {
                        System.out.printf("第 %d 线程名称：%S，已经执行完毕！\n", tempId, Thread.currentThread().getName());
                    }, 60, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        do {
            Runnable task;
            try {
                //task = taskQueue.poll(60, TimeUnit.SECONDS);
                task = taskQueue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            threadPoolExecutor.execute(task);

            System.out.printf("队列正在消化信息，还有%d条未处理\n", taskQueue.size());
        } while (!taskQueue.isEmpty());

        System.out.println("已经跑完了。。。");

        // 关闭线程池
        threadPoolExecutor.shutdown();
    }
}
