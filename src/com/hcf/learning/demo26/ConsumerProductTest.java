package com.hcf.learning.demo26;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerProductTest {
    public static void main(String[] args) {
        MyService6 myService6 = new MyService6();
        ThreadG threadG = new ThreadG(myService6);
        threadG.start();
        ThreadH threadH = new ThreadH(myService6);
        threadH.start();
    }
}

class MyService6 {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;

    public void set() {
        try {
            lock.lock();
            if (hasValue == true) {
                condition.await();
            }
            System.out.println("print value true");
            hasValue = true;
            condition.signal();
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
                condition.await();
            }
            System.out.println("print get false");
            hasValue = false;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class ThreadG extends Thread {
    private MyService6 myService;

    public ThreadG(MyService6 myService) {
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

class ThreadH extends Thread {
    private MyService6 myService;

    public ThreadH(MyService6 myService) {
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
