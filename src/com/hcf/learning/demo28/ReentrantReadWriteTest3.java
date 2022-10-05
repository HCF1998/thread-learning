package com.hcf.learning.demo28;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteTest3 {
    public static void main(String[] args) {
        MyService3 myService = new MyService3();
        ThreadC thread1 = new ThreadC(myService);
        thread1.start();
        ThreadD thread2 = new ThreadD(myService);
        thread2.start();
    }
}

class MyService3 {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            lock.readLock().lock();
            System.out.println("get read lock " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write() {
        try {
            lock.writeLock().lock();
            System.out.println("get write lock  " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}

class ThreadC extends Thread {
    private MyService3 service;

    public ThreadC(MyService3 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.read();
    }
}
class ThreadD extends Thread {
    private MyService3 service;

    public ThreadD(MyService3 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.write();
    }
}