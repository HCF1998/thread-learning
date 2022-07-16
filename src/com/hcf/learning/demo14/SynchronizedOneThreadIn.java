package com.hcf.learning.demo14;

public class SynchronizedOneThreadIn {

    public void serviceMethod() {
        try {
            synchronized (this) {
                System.out.println("begin time = " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("end time = " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA extends Thread {
    private SynchronizedOneThreadIn service;

    public ThreadA(SynchronizedOneThreadIn service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.serviceMethod();
    }
}

class ThreadB extends Thread {
    private SynchronizedOneThreadIn service;

    public ThreadB(SynchronizedOneThreadIn service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.serviceMethod();
    }
}

class Run2{
    public static void main(String[] args) {
        SynchronizedOneThreadIn service = new SynchronizedOneThreadIn();

        ThreadA threadA = new ThreadA(service);
        threadA.setName("a");
        threadA.start();
        ThreadB threadB = new ThreadB(service);
        threadB.setName("a");
        threadB.start();
    }
}