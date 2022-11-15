package com.hcf.learning.demo35;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest2 {
    public static void main(String[] args) {
        try {
            MyServiceB myServiceB = new MyServiceB();
            ThreadB myThreadB = new ThreadB(myServiceB);
            myThreadB.setName("b");
            myThreadB.start();

            Thread.sleep(3000);
            System.out.println("queue size " + myServiceB.queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyServiceB {
    public TransferQueue queue = new LinkedTransferQueue();
}

class ThreadB extends Thread {
    private MyServiceB serviceB;

    public ThreadB(MyServiceB serviceB) {
        super();
        this.serviceB = serviceB;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " beginB " + System.currentTimeMillis());
            serviceB.queue.transfer("comeFromThreadB");
            System.out.println(Thread.currentThread().getName() + " endB " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
