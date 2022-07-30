package com.hcf.learning.demo18;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicIntegerNoSafe {
    public static void main(String[] args) {
        try {
            MyService myService = new MyService();

            MyThread1[] myThreadArray = new MyThread1[5];

            for (int i = 0; i < myThreadArray.length; i++) {
                myThreadArray[i] = new MyThread1(myService);
            }
            for (int i = 0; i < myThreadArray.length; i++) {
                myThreadArray[i].start();
            }
            Thread.sleep(1000);
            System.out.println(myService.aiRef.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyService {
    public static AtomicLong aiRef = new AtomicLong();

    //  synchronized
    public void addNum() {
        System.out.println(Thread.currentThread().getName() + " added 100 : " + aiRef.addAndGet(100));
        aiRef.addAndGet(1);
    }
}

class MyThread1 extends Thread {

    private MyService myService;

    public MyThread1(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.addNum();
    }
}