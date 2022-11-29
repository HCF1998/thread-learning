package com.hcf.learning.demo36;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest15CompleteTaskCount {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("print:" + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 5,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        Thread.sleep(1000);
        System.out.println(executor.getCompletedTaskCount());
        Thread.sleep(1000);
        System.out.println(executor.getCompletedTaskCount());
        Thread.sleep(1000);
        System.out.println(executor.getCompletedTaskCount());
        Thread.sleep(1000);
        System.out.println(executor.getCompletedTaskCount());
        Thread.sleep(1000);
        System.out.println(executor.getCompletedTaskCount());

    }
}
