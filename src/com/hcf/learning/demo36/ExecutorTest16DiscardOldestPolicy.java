package com.hcf.learning.demo36;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest16DiscardOldestPolicy {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(2);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5,
                TimeUnit.SECONDS, queue, new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 5; i++) {
            MyRunnable16 r = new MyRunnable16("Runnable " + (i + 1));
            executor.execute(r);
        }
        Thread.sleep(50);
        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            System.out.println(((MyRunnable16) o).getUsername());
        }
        executor.execute(new MyRunnable16("Runnable " + 6));
        iterator = queue.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            System.out.println(((MyRunnable16) o).getUsername());
        }
        executor.execute(new MyRunnable16("Runnable " + 7));
        iterator = queue.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            System.out.println(((MyRunnable16) o).getUsername());
        }
    }
}

class MyRunnable16 implements Runnable {
    private String username;
    ;

    public MyRunnable16(String username) {
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
            System.out.println(username + " run");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}