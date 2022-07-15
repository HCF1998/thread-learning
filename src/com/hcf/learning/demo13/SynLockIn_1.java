package com.hcf.learning.demo13;

public class SynLockIn_1 {
    synchronized public void service1() {
        System.out.println("service1");
        service2();
    }

    synchronized public void service2() {
        System.out.println("service2");
        service3();
    }

    synchronized public void service3() {
        System.out.println("service3");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        SynLockIn_1 synLockIn_1 = new SynLockIn_1();
        synLockIn_1.service1();
    }
}

class Run{
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}