package com.hcf.learning.demo26;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionWaitNotify2 {
    public static void main(String[] args) {
        MyService3 myService3 = new MyService3();
        MyThreadA myThreadA = new MyThreadA(myService3);
        myThreadA.start();
        MyThreadA myThreadA1 = new MyThreadA(myService3);
        myThreadA1.start();
        MyThreadA myThreadA2 = new MyThreadA(myService3);
        myThreadA2.start();
    }
}
class MyService3{
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void waitMethod(){
        try{
            lock.lock();
            System.out.println("A");
            condition.await();
            System.out.println("B");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
            System.out.println("unlock");
        }
    }
}
class MyThreadA extends Thread{
    private MyService3 service;

    public MyThreadA(MyService3 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.waitMethod();
    }
}