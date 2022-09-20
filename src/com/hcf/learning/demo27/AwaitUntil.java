package com.hcf.learning.demo27;

import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitUntil {
    public static void main(String[] args) throws InterruptedException {
        MyService5 myService5 = new MyService5();
        MyThreadA myThreadA = new MyThreadA(myService5);
        myThreadA.start();

        Thread.sleep(2000);
        MyThreadB myThreadB = new MyThreadB(myService5);
        myThreadB.start();
    }
}

class MyService5 {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void waitMethod() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, 10);
            lock.lock();
            System.out.println("wait begin time = " + System.currentTimeMillis());
            condition.awaitUntil(calendar.getTime());
            System.out.println("wait end time = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void notifyMethod() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, 10);
            lock.lock();
            System.out.println("notify begin time = " + System.currentTimeMillis());
            condition.signalAll();
            System.out.println("notify end time = " + System.currentTimeMillis());
        } finally {
            lock.unlock();
        }
    }
}

class MyThreadA extends Thread{
    private MyService5 service;
    public MyThreadA(MyService5 service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.waitMethod();
    }
}
class MyThreadB extends Thread{
    private MyService5 service;
    public MyThreadB(MyService5 service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.notifyMethod();
    }
}