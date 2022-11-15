package com.hcf.learning.demo35;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest3 {
    public static void main(String[] args) {
        try {
            MyServiceC myServiceC = new MyServiceC();
            MyThreadC myThreadC = new MyThreadC(myServiceC);
            myThreadC.setName("C");
            MyThreadD myThreadD = new MyThreadD(myServiceC);
            myThreadD.setName("D");
            myThreadC.start();
            Thread.sleep(4000);
            myThreadD.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyServiceC {
    public TransferQueue queue = new LinkedTransferQueue();
}

class MyThreadC extends Thread {
    private MyServiceC myService;

    public MyThreadC(MyServiceC myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " beginC " + System.currentTimeMillis());
            System.out.println("get value: " + myService.queue.take());
            System.out.println(Thread.currentThread().getName() + " endC " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThreadD extends Thread {
    private MyServiceC myService;

    public MyThreadD(MyServiceC myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " beginD " + System.currentTimeMillis());
            myService.queue.transfer("comeFromMyThreadD");
            System.out.println(Thread.currentThread().getName() + " endD " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}