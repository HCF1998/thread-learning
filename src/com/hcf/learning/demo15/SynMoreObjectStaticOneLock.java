package com.hcf.learning.demo15;

public class SynMoreObjectStaticOneLock {

    public static void main(String[] args) {
        Service4 service = new Service4();
        Service4 service1 = new Service4();

        ThreadJ threadJ = new ThreadJ(service, "J");
        threadJ.start();

        ThreadK threadK = new ThreadK(service1, "K");
        threadK.start();
    }
}

class ThreadJ extends Thread {
    private Service4 service4;

    public ThreadJ(Service4 service4, String name) {
        super();
        this.setName(name);
        this.service4 = service4;
    }

    @Override
    public void run() {
        service4.printA();
    }
}

class ThreadK extends Thread {
    private Service4 service4;

    public ThreadK(Service4 service4, String name) {
        super();
        this.setName(name);
        this.service4 = service4;
    }

    @Override
    public void run() {
        service4.printB();
    }
}

class Service4 {
    synchronized public static void printA() {
        try {
            System.out.println("Thread name = " + Thread.currentThread().getName()
                    + " join in printA() at " + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("Thread name = " + Thread.currentThread().getName()
                    + " leave printA() at " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void printB() {
        System.out.println("Thread name = " + Thread.currentThread().getName()
                + " join in printB() at " + System.currentTimeMillis());
        System.out.println("Thread name = " + Thread.currentThread().getName()
                + " leave printB() at " + System.currentTimeMillis());
    }
}