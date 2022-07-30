package com.hcf.learning.demo19;

public class WaitNotifyTest {
    public static void main(String[] args) {
        try{
            Object o = new Object();
            MyThread myThread = new MyThread(o);
            myThread.start();

            Thread.sleep(3000);

            MyThread1 myThread1 = new MyThread1(o);
            myThread1.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {
    private Object lock;

    public MyThread(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("start wait " + System.currentTimeMillis());
                lock.wait();
                System.out.println("end wait " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread1 extends Thread {
    private Object lock;

    public MyThread1(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("start notify " + System.currentTimeMillis());
            lock.notify();
            System.out.println("end notify " + System.currentTimeMillis());
        }
    }
}