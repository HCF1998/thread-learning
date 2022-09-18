package com.hcf.learning.demo27;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock {
    public static void main(String[] args) {
        final MyService4 myService4 = new MyService4();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myService4.waitMethod();
            }
        };
        //Thread threadA = new Thread(runnable);
        //threadA.setName("A");
        //threadA.start();
        //Thread threadB = new Thread(runnable);
        //threadB.setName("B");
        //threadB.start();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" call method "+System.currentTimeMillis());
                myService4.waitMethod2();
            }
        };
        Thread threadC = new Thread(runnable1);
        threadC.setName("C");
        threadC.start();
        Thread threadD = new Thread(runnable1);
        threadD.setName("D");
        threadD.start();
    }
}

class MyService4 {
    private ReentrantLock lock = new ReentrantLock();

    public void waitMethod() {
        if (lock.tryLock()) {
            System.out.println(Thread.currentThread().getName() + " get lock");
        } else {
            System.out.println(Thread.currentThread().getName() + " get lock failed");
        }
        System.out.println(Thread.currentThread().getName() + " print test");
    }

    public void waitMethod2() {
        try {
            if (lock.tryLock(3, TimeUnit.SECONDS)) {
                System.out.println(" " + Thread.currentThread().getName() + ",get lock at " + System.currentTimeMillis());
                Thread.sleep(10000);
            } else {
                System.out.println(" " + Thread.currentThread().getName() + ",get lock failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            if(lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }
}
