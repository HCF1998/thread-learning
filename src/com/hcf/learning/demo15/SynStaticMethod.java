package com.hcf.learning.demo15;

public class SynStaticMethod {
    public static void main(String[] args) {
        ThreadE threadE = new ThreadE();
        threadE.setName("E");
        threadE.start();

        ThreadF threadF = new ThreadF();
        threadF.setName("F");
        threadF.start();
    }
}

class Service2 {
    synchronized public static void printA() {
        try {
            System.out.println("Thread name = " + Thread.currentThread().getName()
                    + " join in printA() at " + System.currentTimeMillis());
            Thread.sleep(1500);
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

class ThreadE extends Thread {
    @Override
    public void run() {
        Service2.printA();
    }
}

class ThreadF extends Thread {
    @Override
    public void run() {
        Service2.printB();
    }
}


