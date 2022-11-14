package com.hcf.learning.demo35;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest1 {
    public static void main(String[] args) {
        MyService2 myService2 = new MyService2();
        ThreadA threadA = new ThreadA(myService2);
        threadA.start();
    }
}
class MyService2{
    public TransferQueue queue = new LinkedTransferQueue();
}

class ThreadA extends Thread{
    private MyService2 myService;

    public ThreadA(MyService2 myService){
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        try{
            System.out.println(Thread.currentThread().getName()+" begin "+System.currentTimeMillis());
            System.out.println("get value: "+myService.queue.take());
            System.out.println(Thread.currentThread().getName()+" end "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}