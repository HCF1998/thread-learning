package com.hcf.learning.demo27;

import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptibly {
    public static void main(String[] args) throws InterruptedException {
        MyService3 myService3 = new MyService3();
        ThreadA threadA = new ThreadA(myService3);
        threadA.setName("A");
        threadA.start();
        Thread.sleep(500);

        ThreadA threadB = new ThreadA(myService3);
        threadB.setName("B");
        threadB.start();
        Thread.sleep(500);

        threadB.interrupt();
        System.out.println("B interrupt failed");
    }
}

class MyService3 {
    private ReentrantLock lock = new ReentrantLock();

    public void testMethod() throws InterruptedException {
        lock.lockInterruptibly();
        System.out.println("begin " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        for (int i = 0; i < Integer.MAX_VALUE / 10; i++) {
            String newString = new String();
            Math.random();
            Thread.currentThread().yield();
        }
        System.out.println("end " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        lock.unlock();
    }
}

class ThreadA extends Thread {
    private MyService3 service;

    public ThreadA(MyService3 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        try {
            service.testMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
