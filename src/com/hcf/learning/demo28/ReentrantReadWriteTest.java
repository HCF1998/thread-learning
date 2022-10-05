package com.hcf.learning.demo28;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteTest {
    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA thread1 = new ThreadA(myService);
        thread1.start();
        ThreadA thread2 = new ThreadA(myService);
        thread2.start();
    }
}

class MyService {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private String username = "abc";

    public void testMethod() {
        try {
            lock.readLock().lock();
            System.out.println("begin " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            System.out.println("print username " + username);
            Thread.sleep(4000);
            System.out.println("end " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            lock.readLock().unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreadA extends Thread {
    private MyService service;

    public ThreadA(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}