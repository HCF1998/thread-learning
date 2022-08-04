package com.hcf.learning.demo19;

public class NotifyTest {
    public static void main(String[] args) throws InterruptedException {
        Service2 service2 = new Service2();
        ThreadG threadG = new ThreadG(service2);
        threadG.start();
        Thread.sleep(50);
        ThreadH threadH = new ThreadH(service2);
        threadH.start();
    }
}

class Service2 {
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
        try {
            synchronized (lock) {
                System.out.println("begin notify() ThreadName = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
                lock.notify();
                Thread.sleep(2000);
                System.out.println("end notify() ThreadName = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadG extends Thread {
    private Service2 service;

    public ThreadG(Service2 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.waitMethod();
    }
}
class ThreadH extends Thread {
    private Service2 service;

    public ThreadH(Service2 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.notifyMethod();
    }
}