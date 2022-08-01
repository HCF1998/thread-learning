package com.hcf.learning.demo19;

import java.util.ArrayList;
import java.util.List;

public class WaitNotifyService {

    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        MyThreadA myThreadA = new MyThreadA(service);
        myThreadA.start();
        Thread.sleep(5000);
        MyThreadB myThreadB = new MyThreadB(service);
        myThreadB.start();
    }
}

class MyList2 {
    volatile private List list = new ArrayList();

    public void add() {
        list.add("anyString");
    }

    public int size() {
        return list.size();
    }
}

class MyService {
    private Object lock = new Object();
    private MyList2 list = new MyList2();

    public void waitMethod() {
        try {
            synchronized (lock) {
                if (list.size() != 3) {
                    System.out.println("begin wait " + System.currentTimeMillis() + " " + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("end wait " + System.currentTimeMillis() + " " + Thread.currentThread().getName());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void notifyMethod() {
        try {
            synchronized (lock) {
                System.out.println("begin notify " + System.currentTimeMillis() + " " + Thread.currentThread().getName());
                for (int i = 0; i < 5; i++) {
                    list.add();
                    if (list.size() == 3) {
                        lock.notify();
                        System.out.println("just notify");
                    }
                    System.out.println("added: " + (i + 1));
                    Thread.sleep(1000);
                }
                System.out.println("end notify " + System.currentTimeMillis() + " " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThreadA extends Thread {
    private MyService service;

    public MyThreadA(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.waitMethod();
    }
}

class MyThreadB extends Thread {
    private MyService service;

    public MyThreadB(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.notifyMethod();
    }
}