package com.hcf.learning.demo26;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerProductTest2 {
    public static void main(String[] args) {
        MyService7 myService7 = new MyService7();
        ThreadI[] threadI = new ThreadI[10];
        ThreadJ[] threadJ = new ThreadJ[10];

        for (int i = 0; i < 10; i++) {
            threadI[i] = new ThreadI(myService7);
            threadJ[i] = new ThreadJ(myService7);
            threadI[i].start();
            threadJ[i].start();
        }
    }
}

class MyService7 {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;

    public void set() {
        try {
            lock.lock();
            while (hasValue == true) {
                System.out.println("has value .....");
                condition.await();
            }
            System.out.println("print value !!!!!");
            hasValue = true;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            while (hasValue == false) {
                System.out.println("no value ~~~~~");
                condition.await();
            }
            System.out.println("get value +++++");
            hasValue = false;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class ThreadI extends Thread {
    private MyService7 myService;

    public ThreadI(MyService7 myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            myService.set();
        }
    }
}

class ThreadJ extends Thread {
    private MyService7 myService;

    public ThreadJ(MyService7 myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            myService.get();
        }
    }
}