package com.hcf.learning.demo27;

import java.util.concurrent.locks.ReentrantLock;

public class QueueLength {
    public static void main(String[] args) throws InterruptedException {
        final MyService1 myService = new MyService1();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myService.serviceMethod1();
            }
        };
        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(runnable);
        }
        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }
        Thread.sleep(2000);
        System.out.println("queue length = " + myService.lock.getQueueLength());
    }
}

class MyService1 {
    public ReentrantLock lock = new ReentrantLock();

    public void serviceMethod1() {
        try {
            lock.lock();
            System.out.println("ThreadName = " + Thread.currentThread().getName() + " come into method");
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
