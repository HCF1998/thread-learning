package com.hcf.learning.demo10;

public class ThreadPriorityTest {
    public static void main(String[] args) {
        System.out.println("Main Thread begin priority = " + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        System.out.println("Main Thread begin priority = " + Thread.currentThread().getPriority());
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
    }
}
class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread2 Run Priority :" + this.getPriority());
        MyThread3 myThread3 = new MyThread3();
        myThread3.start();
    }
}
class MyThread3 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread3 Run Priority :" + this.getPriority());
    }
}
