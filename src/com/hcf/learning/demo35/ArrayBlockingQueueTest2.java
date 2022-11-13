package com.hcf.learning.demo35;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueTest2 {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService(true);
        MyThread[] myThreads1 = new MyThread[10];
        MyThread[] myThreads2 = new MyThread[10];

        for (int i = 0; i < myThreads1.length; i++) {
            myThreads1[i] = new MyThread(myService);
            myThreads1[i].setName("+++");
        }
        for (int i = 0; i < myThreads1.length; i++) {
            myThreads1[i].start();
        }
        for (int i = 0; i < myThreads2.length; i++) {
            myThreads2[i] = new MyThread(myService);
            myThreads2[i].setName("---");
        }
        Thread.sleep(300);
        myService.queue.put("abc");
        myService.queue.put("abc");
        myService.queue.put("abc");
        myService.queue.put("abc");
        myService.queue.put("abc");
        myService.queue.put("abc");
        myService.queue.put("abc");
        myService.queue.put("abc");
        myService.queue.put("abc");
        myService.queue.put("abc");
        for (int i = 0; i < myThreads2.length; i++) {
            myThreads2[i].start();
        }
    }
}

class MyService {
    public ArrayBlockingQueue queue;

    public MyService(boolean fair) {
        queue = new ArrayBlockingQueue(10, fair);
    }

    public void take() {
        try {
            System.out.println(Thread.currentThread().getName() + " take");
            String takeString = "" + queue.take();
            System.out.println(Thread.currentThread().getName() + " take value = " + takeString);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyThread extends Thread {
    private MyService service;

    public MyThread(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.take();
    }
}