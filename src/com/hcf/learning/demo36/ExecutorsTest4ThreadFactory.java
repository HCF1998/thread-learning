package com.hcf.learning.demo36;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExecutorsTest4ThreadFactory {
    public static void main(String[] args) {
        MyThreadFactory factory = new MyThreadFactory();
        ExecutorService executorService = Executors.newCachedThreadPool(factory);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread running " + System.currentTimeMillis() + " " + Thread.currentThread().getName());
            }
        });
    }
}

class MyThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setName("Factory create " + Math.random());
        return t;
    }
}
