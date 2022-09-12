package com.hcf.learning.demo27;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairAndNoFair {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService(true);
        MyThread[] array1 = new MyThread[10];
        MyThread[] array2 = new MyThread[10];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = new MyThread(myService);
            array1[i].setName("array1+++" + (i + 1));
        }
        for (int i = 0; i < array1.length; i++) {
            array1[i].start();
        }
        for (int i = 0; i < array2.length; i++) {
            array2[i] = new MyThread(myService);
            array2[i].setName("array2---" + (i + 1));
        }
        Thread.sleep(500);
        for (int i = 0; i < array2.length; i++) {
            array2[i].start();
        }
    }
}

class MyService {
    public Lock lock;

    public MyService(boolean fair) {
        lock = new ReentrantLock(fair);
    }

    public void testMetod() {
        try {
            lock.lock();
            System.out.println("testMethod " + Thread.currentThread().getName());
            Thread.sleep(500);
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {
    private MyService service;

    public MyThread(MyService service) {
        super();
        this.service = service;
    }

    public void run() {
        service.testMetod();
    }
}
