package org.hjw.threadInterrupt;

/**
 * @PackageClassName: org.hjw.threadInterrupt.ThreadInterruptExceptionHandlerDemo
 * @Description: 异常try进行处理线程中断
 * @Author: JerryH
 * @Date: 2023-06-29, 0029 上午 11:41
 */
public class ThreadInterruptExceptionHandlerDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = runThread();
        thread.start();

        //Thread.sleep(20L);

        // 对于进行sleep的线程打断，无论是先执行sleep，还是先执行interrupt，都会进行进行打断此线程病抛出InterruptException
        thread.interrupt();
    }

    public static Thread runThread() {

        return new Thread(() -> {
            try {
                for (int i = 5000; i > 0; i--) {
                    // 打断标识
                    System.out.println("倒数：" + i);
                }
                Thread.sleep(2000L);
                System.out.println("睡醒了，继续干活。。。。");
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            System.out.println("我还在呐，还没停止。。。");
        }, "测试interrupt线程");
    }
}
