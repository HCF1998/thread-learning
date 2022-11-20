package com.hcf.learning.demo36;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Runnable1 begin " + System.currentTimeMillis());
                    Thread.sleep(2000);
                    System.out.println("A");
                    System.out.println("Runnable1 end " + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Runnable2 begin " + System.currentTimeMillis());
                    Thread.sleep(2000);
                    System.out.println("B");
                    System.out.println("Runnable2 end " + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        ExecutorService executorService2 = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService2.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("run");
                }
            });
        }
    }
}
