package com.hcf.learning.demo36;

import java.util.concurrent.*;

public class ExecutorTest13RejectedExecutionHandler {
    public static void main(String[] args) {
        MyRunnable13 myRunnable13 = new MyRunnable13("test1");
        MyRunnable13 myRunnable132 = new MyRunnable13("test2");
        MyRunnable13 myRunnable133 = new MyRunnable13("test3");
        MyRunnable13 myRunnable134 = new MyRunnable13("test4");
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 9999L, TimeUnit.SECONDS, new SynchronousQueue<>());
        pool.setRejectedExecutionHandler(new MyRejectedExecutionHandler());
        pool.execute(myRunnable13);
        pool.execute(myRunnable132);
        pool.execute(myRunnable133);
        pool.execute(myRunnable134);
    }
}

class MyRunnable13 implements Runnable {
    private String username;

    public MyRunnable13(String username) {
        super();
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

class MyRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(((MyRunnable13)r).getUsername()+" rejected execute");
    }
}