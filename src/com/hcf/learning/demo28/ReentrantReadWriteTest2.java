package com.hcf.learning.demo28;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteTest2 {
    public static void main(String[] args) {
        MyService2 myService = new MyService2();
        ThreadB thread1 = new ThreadB(myService);
        thread1.start();
        ThreadB thread2 = new ThreadB(myService);
        thread2.start();
    }
}
class MyService2 {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private String username = "abc";

    public void testMethod() {
        try {
            lock.writeLock().lock();
            System.out.println("get write lock  " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
    }
}
class ThreadB extends Thread {
    private MyService2 service;

    public ThreadB(MyService2 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}