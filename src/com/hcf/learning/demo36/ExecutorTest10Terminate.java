package com.hcf.learning.demo36;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest10Terminate {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable10 myRunnable10 = new MyRunnable10();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 999, 9999, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        executor.execute(myRunnable10);
        executor.execute(myRunnable10);
        executor.execute(myRunnable10);
        executor.execute(myRunnable10);
        System.out.println(executor.isTerminating() + " " + executor.isTerminated());
        executor.shutdown();
        Thread.sleep(1000);
        System.out.println(executor.isTerminating() + " " + executor.isTerminated());
        Thread.sleep(1000);
        System.out.println(executor.isTerminating() + " " + executor.isTerminated());
        Thread.sleep(1000);
        System.out.println(executor.isTerminating() + " " + executor.isTerminated());
        Thread.sleep(1000);
        System.out.println(executor.isTerminating() + " " + executor.isTerminated());
        Thread.sleep(1000);
        System.out.println(executor.isTerminating() + " " + executor.isTerminated());
    }
}

class MyRunnable10 implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " begin " + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " end " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
