package com.hcf.learning.demo20;

public class WaitTimeBackLock {
    public static void main(String[] args) {
        MyService1 myService1 = new MyService1();
        ThreadC[] threadCArray = new ThreadC[10];
        for (int i = 0; i < 10; i++) {
            threadCArray[i] = new ThreadC(myService1);
        }
        for (int i = 0; i < 10; i++) {
            threadCArray[i].start();
        }
        ThreadD threadD = new ThreadD(myService1);
        threadD.start();
    }
}

class MyService1 {
    public void testMethod() {
        try {
            synchronized (this) {
                System.out.println("wait begin " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                wait(5000);
                System.out.println("wait end " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void longTimeSyn() {
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadC extends Thread {
    private MyService1 service;

    public ThreadC(MyService1 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}

class ThreadD extends Thread {
    private MyService1 service;

    public ThreadD(MyService1 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.longTimeSyn();
    }
}

