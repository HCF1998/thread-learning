package com.hcf.learning.demo36;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest9IsShutdown {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("begin " + Thread.currentThread().getName());
                    Thread.sleep(1000);
                    System.out.println("end " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2,
                Integer.MAX_VALUE, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        executor.execute(runnable);
        System.out.println("A = " + executor.isShutdown());
        executor.shutdown();
        System.out.println("B = " + executor.isShutdown());
    }
}