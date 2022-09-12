package com.hcf.learning.demo26;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MustUseMoreCondition {
    public static void main(String[] args) throws InterruptedException {
        MyService5 myService5 = new MyService5();

        ThreadE threadE = new ThreadE(myService5);
        threadE.setName("E");
        threadE.start();

        ThreadF threadF = new ThreadF(myService5);
        threadF.setName("F");
        threadF.start();

        Thread.sleep(3000);
        myService5.signalAll();
    }
}
class MyService5{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Condition condition1 = lock.newCondition();

    public void awaitA(){
        try{
            lock.lock();
            System.out.println("begin awaitA time "+System.currentTimeMillis()+" ThreadName = "+Thread.currentThread().getName());
            condition.await();
            System.out.println("end awaitA time "+System.currentTimeMillis()+" ThreadName = "+Thread.currentThread().getName());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void awaitB(){
        try{
            lock.lock();
            System.out.println("begin awaitB time "+System.currentTimeMillis()+" ThreadName = "+Thread.currentThread().getName());
            condition.await();
            System.out.println("end awaitB time "+System.currentTimeMillis()+" ThreadName = "+Thread.currentThread().getName());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void signalAll(){
        try{
            lock.lock();
            System.out.println("signalAll time "+System.currentTimeMillis()+" ThreadName = "+Thread.currentThread().getName());
            condition.signalAll();
        }finally{
            lock.unlock();
        }
    }
}
class ThreadE extends Thread{
    private MyService5 service;

    public ThreadE(MyService5 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitA();
    }
}

class ThreadF extends Thread{
    private MyService5 service;

    public ThreadF(MyService5 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitB();
    }
}
