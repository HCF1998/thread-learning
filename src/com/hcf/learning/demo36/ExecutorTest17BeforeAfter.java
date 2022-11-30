package com.hcf.learning.demo36;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest17BeforeAfter {
    public static void main(String[] args) {
        MyThreadPoolExecutor executor = new MyThreadPoolExecutor(2,2,Integer.MAX_VALUE,
                TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
        executor.execute(new MyRunnable17("A1"));
        executor.execute(new MyRunnable17("A2"));
        executor.execute(new MyRunnable17("A3"));
        executor.execute(new MyRunnable17("A4"));
    }
}

class MyThreadPoolExecutor extends ThreadPoolExecutor {
    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        System.out.println(((MyRunnable17) r).getUsername() + " executed");
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        System.out.println("ready to execute " + ((MyRunnable17) r).getUsername());
    }
}

class MyRunnable17 implements Runnable {
    private String username;

    public MyRunnable17(String username) {
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
            System.out.println("print begin " + username + " " + System.currentTimeMillis());
            Thread.sleep(4000);
            System.out.println("print end " + username + " " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}