package com.hcf.learning.demo9;

import java.util.concurrent.locks.LockSupport;

public class LockSupport2Test {
    public static void main(String[] args) throws InterruptedException {
        MyThread3 myThread3 = new MyThread3();
        myThread3.start();
        Thread.sleep(2000);
        LockSupport.unpark(myThread3);
    }
}

class MyThread3 extends Thread {
    @Override
    public void run() {
        System.out.println("begin: "+System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.park();
        System.out.println("end: "+System.currentTimeMillis());
    }
}
