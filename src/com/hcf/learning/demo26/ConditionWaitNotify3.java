package com.hcf.learning.demo26;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionWaitNotify3 {
    public static void main(String[] args) throws InterruptedException {
        MyService4 myService4 = new MyService4();
        ThreadC threadC = new ThreadC(myService4);
        threadC.start();
        Thread.sleep(3000);
        myService4.signal();
    }
}
class MyService4{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void await(){
        try{
            lock.lock();
            System.out.println("await time = "+System.currentTimeMillis());
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void signal(){
        try{
            lock.lock();
            System.out.println("sinal time = "+System.currentTimeMillis());
            condition.signal();
        }finally{
            lock.unlock();
        }
    }
}

class ThreadC extends Thread{
    private MyService4 service;

    public ThreadC(MyService4 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }
}
