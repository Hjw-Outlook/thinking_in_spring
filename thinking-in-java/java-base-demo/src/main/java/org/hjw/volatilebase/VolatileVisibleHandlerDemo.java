package org.hjw.volatilebase;

/**
 * @PackageClassName: org.hjw.volatilebase.VolatileVisibleHandlerDemo
 * @Description: volatile 关键字的可见性
 * @Author: JerryH
 * @Date: 2023-06-29, 0029 下午 02:19
 */
public class VolatileVisibleHandlerDemo {

    //private static boolean flag;// 由于没有添加volatile所以其他线程无法可见flag已被其他线程修改
    private static volatile boolean flag;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (!flag){
                // 不能添加此打印，否则此线程进行获取到新的flag
                //System.out.println("当前flag：" + flag);
            }

            System.out.println("跳出循环，同时flag已经修改！，修改值 —> " + flag);
        }).start();

        Thread.sleep(200L);

        new Thread(() -> {
            flag = true;
        }).start();
    }
}
