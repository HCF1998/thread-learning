package com.hcf.learning.demo36;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest12ExceptionHandler {
    public static void main(String[] args) {
        MyRunnable12 myRunnable12 = new MyRunnable12();
        MyRunnable121 myRunnable121 = new MyRunnable121();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 999, 999L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new MyThreadFactoryA());
        pool.execute(myRunnable12);

        ThreadPoolExecutor pool2 = new ThreadPoolExecutor(2, 999, 999L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        pool2.setThreadFactory(new MyThreadFactoryB());
        pool2.execute(myRunnable121);

    }
}

class MyRunnable12 implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyRunnable121 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
        String abc = null;
        abc.indexOf(0);
        System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
    }
}

class MyThreadFactoryA implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread newThread = new Thread(r);
        newThread.setName("MyThreadFactoryA " + new Date());
        return newThread;
    }
}
class MyThreadFactoryB implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread newThread = new Thread(r);
        newThread.setName("handler");
        newThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("ex handler"+t.getName()+" " + e.getMessage());
                e.printStackTrace();
            }
        });
        return newThread;
    }
}