package com.hcf.learning.demo19;

import java.util.ArrayList;
import java.util.List;

public class WaitNotifySize5 {

    public static void main(String[] args) {
        try{
            Object o = new Object();
            ThreadC threadC = new ThreadC(o);
            threadC.start();

            Thread.sleep(500);
            ThreadD threadD = new ThreadD(o);
            threadD.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyList1 {
    private static List list = new ArrayList();

    public static void add() {
        list.add("anyString");
    }

    public static int size() {
        return list.size();
    }
}

class ThreadC extends Thread {
    private Object lock;

    public ThreadC(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                if (MyList1.size() != 3) {
                    System.out.println("wait begin " + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end " + System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadD extends Thread {
    private Object lock;

    public ThreadD(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    MyList1.add();
                    if (MyList1.size() == 3) {
                        lock.notify();
                        System.out.println("notify");
                    }
                    System.out.println("added " + (i + 1) + " elements");
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
