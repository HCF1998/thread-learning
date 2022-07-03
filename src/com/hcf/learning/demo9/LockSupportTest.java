package com.hcf.learning.demo9;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        Thread.sleep(4000);
        LockSupport.unpark(myThread2);
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("begin: "+System.currentTimeMillis());
        LockSupport.park();
        System.out.println("end: "+System.currentTimeMillis());
    }
}