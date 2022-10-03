package com.hcf.learning.demo27;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitUniterruptibly {
    public static void main(String[] args) {
        try {
            MyService6 myService6 = new MyService6();
            MyThread1 myThread1 = new MyThread1(myService6);
            myThread1.start();
            Thread.sleep(3000);
            myThread1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyService6 {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void testMethod() {
        try {
            lock.lock();
            System.out.println("wait begin");
            //condition.await();
            condition.awaitUninterruptibly();
            System.out.println("wait end");
        } finally {
            lock.unlock();
        }
    }
}

class MyThread1 extends Thread {
    private MyService6 service;

    public MyThread1(MyService6 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}