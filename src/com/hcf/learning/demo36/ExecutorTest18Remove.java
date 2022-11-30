package com.hcf.learning.demo36;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest18Remove {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " begin");
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + " end");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " begin");
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + " end");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " begin");
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + " end");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        executor.execute(runnable);
        executor.execute(runnable2);
        executor.submit(runnable3);
        Thread.sleep(1000);
        if (!executor.remove(runnable)) {
            System.out.println("can't remove runnable");
        }
        if (executor.remove(runnable2)) {
            System.out.println("remove runnable2");
        }
        if (!executor.remove(runnable3)){
            System.out.println("can't remove runnable3");
        }

    }
}
