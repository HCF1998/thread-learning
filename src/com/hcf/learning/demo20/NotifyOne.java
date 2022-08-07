package com.hcf.learning.demo20;


public class NotifyOne {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        for (int i = 0; i < 10; i++) {
            ThreadA threadA = new ThreadA(myService);
            threadA.start();
        }

        Thread.sleep(1000);

        ThreadB t1 = new ThreadB(myService);
        t1.start();
        //Thread.sleep(500);
        //ThreadB t2 = new ThreadB(myService);
        //t2.start();
        //Thread.sleep(500);
        //ThreadB t3 = new ThreadB(myService);
        //t3.start();
        //Thread.sleep(500);
        //ThreadB t4 = new ThreadB(myService);
        //t4.start();
        //Thread.sleep(500);
        //ThreadB t5 = new ThreadB(myService);
        //t5.start();
        //Thread.sleep(500);

    }
}
class MyService{
    private Object lock = new Object();

    public void waitMethod() {
        try {
            synchronized (lock) {
                System.out.println("begin wait() ThreadName = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
                lock.wait();
                System.out.println("end wait() ThreadName = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void notifyMethod() {
            synchronized (lock) {
                System.out.println("---being notify() ThreadName = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
                lock.notifyAll();
                System.out.println("---end notify() ThreadName = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
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
        service.waitMethod();
    }
}

class ThreadB extends Thread {
    private MyService service;

    public ThreadB(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.notifyMethod();
    }
}