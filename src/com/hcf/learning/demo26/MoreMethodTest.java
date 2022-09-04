package com.hcf.learning.demo26;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MoreMethodTest {
    public static void main(String[] args) throws InterruptedException {
        MyService1 myService1 = new MyService1();

        ThreadA threadA = new ThreadA(myService1);
        threadA.setName("A");
        threadA.start();

        ThreadAA threadAA = new ThreadAA(myService1);
        threadAA.setName("AA");
        threadAA.start();

        Thread.sleep(100);

        ThreadB threadB = new ThreadB(myService1);
        threadB.setName("B");
        threadB.start();
        ThreadBB threadBB = new ThreadBB(myService1);
        threadBB.setName("BB");
        threadBB.start();
    }
}

class MyService1 {
    private Lock lock = new ReentrantLock();

    public void methodA() {
        try {
            lock.lock();
            System.out.println("methodA begin ThreadName = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodA end ThreadName = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        try {
            lock.lock();
            System.out.println("methodB begin ThreadName = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodB end ThreadName = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class ThreadA extends Thread {
    private MyService1 myService;

    public ThreadA(MyService1 myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.methodA();
    }
}

class ThreadAA extends Thread {
    private MyService1 myService;

    public ThreadAA(MyService1 myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.methodA();
    }
}

class ThreadB extends Thread {
    private MyService1 myService;

    public ThreadB(MyService1 myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.methodA();
    }
}class ThreadBB extends Thread {
    private MyService1 myService;

    public ThreadBB(MyService1 myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.methodA();
    }
}

