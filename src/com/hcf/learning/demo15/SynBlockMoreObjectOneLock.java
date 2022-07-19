package com.hcf.learning.demo15;

public class SynBlockMoreObjectOneLock {
    public static void main(String[] args) {
        Service5 service = new Service5();
        Service5 service1 = new Service5();

        ThreadL threadL = new ThreadL(service, "L");
        threadL.start();
        ThreadM threadM = new ThreadM(service1, "M");
        threadM.start();
    }
}

class ThreadL extends Thread {
    private Service5 service5;

    public ThreadL(Service5 service5, String name) {
        super();
        this.setName(name);
        this.service5 = service5;
    }

    @Override
    public void run() {
        service5.printA();
    }
}

class ThreadM extends Thread {
    private Service5 service5;

    public ThreadM(Service5 service5, String name) {
        super();
        this.setName(name);
        this.service5 = service5;
    }

    @Override
    public void run() {
        service5.printB();
    }
}

class Service5 {
    public void printA() {
        synchronized (Service5.class) {
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
    }

    public void printB() {
        synchronized (Service5.class) {
            System.out.println("Thread name = " + Thread.currentThread().getName()
                    + " join in printB() at " + System.currentTimeMillis());
            System.out.println("Thread name = " + Thread.currentThread().getName()
                    + " leave printB() at " + System.currentTimeMillis());
        }
    }
}
