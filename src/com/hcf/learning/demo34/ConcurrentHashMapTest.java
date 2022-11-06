package com.hcf.learning.demo34;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        MyService3 myService3 = new MyService3();
        MyThreadA myThreadA = new MyThreadA(myService3);
        MyThreadB myThreadB = new MyThreadB(myService3);
        myThreadA.start();
        myThreadB.start();

    }
}

class MyService3 {
    public ConcurrentHashMap map = new ConcurrentHashMap<>();

    public MyService3() {
        for (int i = 0; i < 1000; i++) {
            map.put(Thread.currentThread().getName() + i + 1, "abc");
        }
    }

    public void testMethod() {
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            iterator.remove();
            System.out.println(map.size() + " " + Thread.currentThread().getName());
        }
    }
}

class MyThreadA extends Thread {
    private MyService3 myService3;

    public MyThreadA(MyService3 myService3) {
        super();
        this.myService3 = myService3;
    }

    @Override
    public void run() {
        myService3.testMethod();
    }
}

class MyThreadB extends Thread {
    private MyService3 myService3;

    public MyThreadB(MyService3 myService3) {
        super();
        this.myService3 = myService3;
    }

    @Override
    public void run() {
        myService3.testMethod();
    }
}