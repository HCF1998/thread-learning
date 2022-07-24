package com.hcf.learning.demo17;

public class SetNewStringTwoLock {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();

        ThreadA a = new ThreadA(myService, "A");
        ThreadB b = new ThreadB(myService, "B");

        a.start();
        Thread.sleep(50);
        b.start();
    }
}

class MyService {
    private String lock = "123";

    public void testMethod() {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " begin " + System.currentTimeMillis());
                lock = "456";
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " end " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA extends Thread {
    private MyService service;

    public ThreadA(MyService service, String name) {
        this.setName(name);
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}

class ThreadB extends Thread {
    private MyService service;

    public ThreadB(MyService service, String name) {
        this.setName(name);
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
