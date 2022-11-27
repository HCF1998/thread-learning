package com.hcf.learning.demo36;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest11AwaitTermination {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable11 myRunnable11 = new MyRunnable11();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 999, 999L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        executor.execute(myRunnable11);
        executor.shutdown();
        System.out.println("main begin "+ System.currentTimeMillis());
        System.out.println(executor.awaitTermination(10,TimeUnit.SECONDS));
        System.out.println("main end "+ System.currentTimeMillis());
    }
}

class MyRunnable11 implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}