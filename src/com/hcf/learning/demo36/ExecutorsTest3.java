package com.hcf.learning.demo36;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest3 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MyRunnable2("" + (i + 1)));
        }
        Thread.sleep(1000);
        System.out.println("");
        System.out.println("");
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable2("" + (i + 1)));
        }
    }
}

class MyRunnable2 implements Runnable {
    private String username;

    public MyRunnable2(String username) {
        super();
        this.username = username;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " username=" + username + " begin " + System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName() + " username=" + username + " end " + System.currentTimeMillis());
    }
}
