package com.hcf.learning.demo36;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest9Shutdown {
    public static void main(String[] args) {
        MyRunnable9 myRunnable9 = new MyRunnable9();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 10, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        System.out.println("main end");

        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(7,10, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        executor1.execute(myRunnable9);
        System.out.println("main end2");

        ThreadPoolExecutor executor2 = new ThreadPoolExecutor(7,10, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        executor2.execute(myRunnable9);
        executor2.execute(myRunnable9);
        executor2.execute(myRunnable9);
        executor2.shutdown();
        // throw RejectedExecutionException
        executor2.execute(myRunnable9);
        System.out.println("main end3");

    }
}

class MyRunnable9 implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("begin " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(3999);
            System.out.println("end" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}