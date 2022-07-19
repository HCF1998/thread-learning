package com.hcf.learning.demo15;

public class SynTwoLock {
    public static void main(String[] args) {
        Service3 service3 = new Service3();

        ThreadG threadG = new ThreadG(service3);
        threadG.setName("G");
        threadG.start();

        ThreadH threadH = new ThreadH(service3);
        threadH.setName("H");
        threadH.start();

        ThreadI threadI = new ThreadI(service3, "I");
        threadI.start();
    }

}

class ThreadG extends Thread {
    private Service3 service;

    public ThreadG(Service3 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.printA();
    }
}

class ThreadH extends Thread {
    private Service3 service;

    public ThreadH(Service3 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.printB();
    }
}

class ThreadI extends Thread {
    private Service3 service;

    public ThreadI(Service3 service, String name) {
        super();
        this.setName(name);
        this.service = service;
    }

    @Override
    public void run() {
        service.printC();
    }
}

class Service3 {

    synchronized public static void printA() {
        try {
            System.out.println("Thread name = " + Thread.currentThread().getName()
                    + " join in printA() at " + System.currentTimeMillis());
            Thread.sleep(5000);
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

    synchronized public void printC() {
        System.out.println("Thread name = " + Thread.currentThread().getName()
                + " join in printC() at " + System.currentTimeMillis());
        System.out.println("Thread name = " + Thread.currentThread().getName()
                + " leave printC() at " + System.currentTimeMillis());
    }
}
