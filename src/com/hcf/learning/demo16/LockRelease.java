package com.hcf.learning.demo16;

public class LockRelease {
    public static void main(String[] args) {
        Service3 service3 = new Service3();
        ThreadE e = new ThreadE(service3, "E");
        e.start();
        ThreadF f = new ThreadF(service3, "F");
        f.start();
    }
}

class Service3 {
    Object object = new Object();

    //synchronized public void methodA(){
    public void methodA() {
        // synchronized block
        synchronized (object) {
            System.out.println("methodA begin");
            boolean isContinueRun = true;
            while (isContinueRun) {
            }
            System.out.println("methodA end");
        }
    }

    Object object1 = new Object();

    //synchronized public void methodB() {
    public void methodB() {
        synchronized (object1) {
            System.out.println("methodB begin");
            System.out.println("methodB end");
        }
    }
}

class ThreadE extends Thread {
    private Service3 service;

    public ThreadE(Service3 service, String name) {
        this.setName(name);
        this.service = service;
    }

    @Override
    public void run() {
        service.methodA();
    }
}

class ThreadF extends Thread {
    private Service3 service;

    public ThreadF(Service3 service, String name) {
        this.setName(name);
        this.service = service;
    }

    @Override
    public void run() {
        service.methodB();
    }
}

