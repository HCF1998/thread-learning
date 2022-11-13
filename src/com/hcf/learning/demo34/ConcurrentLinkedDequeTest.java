package com.hcf.learning.demo34;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequeTest {
    public static void main(String[] args) throws InterruptedException {
        MyService8 myService8 = new MyService8();

        MyThread7 myThread7 = new MyThread7(myService8);
        MyThread7 myThread71 = new MyThread7(myService8);
        MyThread8 myThread8 = new MyThread8(myService8);
        MyThread8 myThread81 = new MyThread8(myService8);

        myThread7.start();
        Thread.sleep(1000);
        myThread8.start();
        Thread.sleep(1000);
        myThread71.start();
        Thread.sleep(1000);
        myThread81.start();

    }
}

class MyService8 {
    public ConcurrentLinkedDeque queue = new ConcurrentLinkedDeque();

    public MyService8() {
        for (int i = 0; i < 5; i++) {
            queue.add("string" + (i + 1));
        }
    }
}

class MyThread7 extends Thread {
    private MyService8 myService;

    public MyThread7(MyService8 myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        System.out.println("value=" + myService.queue.pollFirst() + " queue.size()=" + myService.queue.size());
    }
}

class MyThread8 extends Thread {
    private MyService8 myService;

    public MyThread8(MyService8 myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        System.out.println("value=" + myService.queue.pollLast() + " queue.size()=" + myService.queue.size());
    }
}