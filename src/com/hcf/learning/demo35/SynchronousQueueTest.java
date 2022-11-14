package com.hcf.learning.demo35;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {
    public static void main(String[] args) {

        try {
//            SynchronousQueue<String> queue = new SynchronousQueue<String>();
//            System.out.println("step1");
//            queue.put("anyString");
//            System.out.println("step2");
//            System.out.println(queue.take());
//            System.out.println("step3");
            MyService1 myService1 = new MyService1();

            ThreadPut putThread = new ThreadPut(myService1);
            ThreadTake takeThread = new ThreadTake(myService1);

            takeThread.start();
            Thread.sleep(2000);
            putThread.start();

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}

class MyService1 {
    public static SynchronousQueue queue = new SynchronousQueue();

    public void putMethod() {
        try {
            String putString = "anyString" + Math.random();
            System.out.println("putString:" + putString);
            queue.put(putString);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void takeMethod() {
        try {
            System.out.println("take=" + queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadPut extends Thread {
    private MyService1 myService;

    public ThreadPut(MyService1 myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            myService.putMethod();
        }
    }
}

class ThreadTake extends Thread {
    private MyService1 myService;

    public ThreadTake(MyService1 myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            myService.takeMethod();
        }
    }
}