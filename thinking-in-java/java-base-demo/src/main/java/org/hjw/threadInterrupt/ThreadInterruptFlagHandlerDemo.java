package org.hjw.threadInterrupt;


/**
 * @PackageClassName: org.hjw.threadInterrupt.ThreadInterruptFlagHandlerDemo
 * @Description: 通过标记进行打断当前线程的运行
 * @Author: JerryH
 * @Date: 2023-06-29, 0029 下午 01:42
 */
public class ThreadInterruptFlagHandlerDemo {

    private volatile boolean interruptFlag = false;

    public static void main(String[] args) throws InterruptedException {
        ThreadInterruptFlagHandlerDemo demo = new ThreadInterruptFlagHandlerDemo();
        demo.runThread().start();
        Thread.sleep(2L);
        // 主线程进行修改此变量状态
        System.out.println("修改当前变量的线程名称："+ Thread.currentThread().getName());
        demo.interruptFlag = true;
    }

    public Thread runThread() {

        return new Thread(() -> {
            System.out.println("需要打断的线程名称：" + Thread.currentThread().getName());
            int count = 0;
            // 打断标识
            while (!interruptFlag) {
                System.out.println("数字排队：" + count++);

                System.out.println("我还在呐，还没停止。。。");
            }
            System.out.println("已经跳出循环！！！");
        }, "测试interrupt线程");
    }
}
