package com.hcf.learning.demo36;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest9ShutdownNow {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable91 myRunnable91 = new MyRunnable91();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,9999,9999L, TimeUnit.SECONDS,new LinkedBlockingQueue<>());

        pool.execute(myRunnable91);
        pool.execute(myRunnable91);
        pool.execute(myRunnable91);
        pool.execute(myRunnable91);
        Thread.sleep(1000);
        pool.shutdownNow();
        System.out.println("main end");
    }
}

class MyRunnable91 implements Runnable {
    @Override
    public void run() {
        System.out.println("begin "+Thread.currentThread().getName()+" "+System.currentTimeMillis());
        for (int i = 0; i <Integer.MAX_VALUE/50;i++){
            String newString = new String();
            Math.random();
            Math.random();
            Math.random();
            Math.random();
            Math.random();
        }
        System.out.println(" end "+Thread.currentThread().getName()+" "+System.currentTimeMillis());
    }
}