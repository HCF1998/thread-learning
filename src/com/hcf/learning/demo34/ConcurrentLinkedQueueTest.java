package com.hcf.learning.demo34;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueTest {
    public static void main(String[] args) {
        try{
            MyService7 myService7 = new MyService7();
            MyThread5 myThread5 = new MyThread5(myService7);
            MyThread6 myThread6 = new MyThread6(myService7);

            myThread5.start();
            myThread6.start();
            myThread5.join();
            myThread6.join();
            System.out.println(myService7.queue.size());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class MyService7 {
    public ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
}

class MyThread5 extends Thread {
    private MyService7 service;

    public MyThread5(MyService7 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            service.queue.add("MyThread5" + (i + 1));
        }
    }
}

class MyThread6 extends Thread {
    private MyService7 service;

    public MyThread6(MyService7 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            service.queue.add("MyThread6" + (i + 1));
        }
    }
}