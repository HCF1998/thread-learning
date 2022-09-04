package com.hcf.learning.demo26;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionWaitNotify {
    public static void main(String[] args) {
        MyService2 myService2 = new MyService2();
        ThreadA1 threadA1 = new ThreadA1(myService2);
        threadA1.start();
    }
}
class MyService2{
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void await(){
        try{
            condition.await();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
class ThreadA1 extends Thread{
    private MyService2 myService = new MyService2();
    public ThreadA1(MyService2 myService){
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.await();
    }
}
