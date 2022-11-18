package org.hjw.ioc.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName thread.ThreadPoolDemo
 * @Description TODO
 * @Author H_jw
 * @Date 2022-08-12 0012 下午 04:59
 * @Version 1.0
 */
public class ThreadPoolDemo {

    private static final int poolSize = 10;

    private static final ExecutorService executor = Executors.newFixedThreadPool(poolSize);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<String>> list = new ArrayList<>();

        for (int i = 0; i < poolSize; i++) {
            int finalI = i;
            Future<String> submit = executor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "" + finalI ;
                }
            });

            list.add(submit);
        }

        // 关闭线程池
        executor.shutdown();

        for (Future<String> future : list) {
            System.out.println(future.get());
        }

    }



}
