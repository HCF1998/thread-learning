package com.hcf.learning.demo27;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    public static void main(String[] args) {
        MyService7 myService7 = new MyService7();
        for (int i = 0; i < 5; i++) {
            MyThreadA1 myThreadA1 = new MyThreadA1(myService7);
            myThreadA1.start();
            MyThreadA2 myThreadA2 = new MyThreadA2(myService7);
            myThreadA2.start();
            MyThreadA3 myThreadA3 = new MyThreadA3(myService7);
            myThreadA3.start();

        }
    }
}

class MyService7 {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    volatile private int nextWhoPrint = 1;

    public void testMethod1() {
        try {
            lock.lock();
            while (nextWhoPrint != 1) {
                condition.await();
            }
            System.out.println("AAA");
            nextWhoPrint = 2;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void testMethod2() {
        try {
            lock.lock();
            while (nextWhoPrint != 2) {
                condition.await();
            }
            System.out.println("BBB");
            nextWhoPrint = 3;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void testMethod3() {
        try {
            lock.lock();
            while (nextWhoPrint != 3) {
                condition.await();
            }
            System.out.println("CCC");
            nextWhoPrint = 1;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class MyThreadA1 extends Thread {
    private MyService7 service = new MyService7();

    public MyThreadA1(MyService7 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod1();
    }
}

class MyThreadA2 extends Thread {
    private MyService7 service = new MyService7();

    public MyThreadA2(MyService7 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod2();
    }
}

class MyThreadA3 extends Thread {
    private MyService7 service = new MyService7();

    public MyThreadA3(MyService7 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod3();
    }
}
