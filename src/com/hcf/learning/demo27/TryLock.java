package com.hcf.learning.demo27;

import java.util.concurrent.locks.ReentrantLock;

public class TryLock {
    public static void main(String[] args) {
        final MyService4 myService4 = new MyService4();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myService4.waitMethod();
            }
        };
        Thread threadA = new Thread(runnable);
        threadA.setName("A");
        threadA.start();
        Thread threadB = new Thread(runnable);
        threadB.setName("B");
        threadB.start();
    }
}

class MyService4 {
    private ReentrantLock lock = new ReentrantLock();

    public void waitMethod() {
        if (lock.tryLock()) {
            System.out.println(Thread.currentThread().getName() + " get lock");
        } else {
            System.out.println(Thread.currentThread().getName() + " get lock failed");
        }
        System.out.println(Thread.currentThread().getName() + " print test");
    }
}
