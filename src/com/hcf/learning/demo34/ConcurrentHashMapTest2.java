package com.hcf.learning.demo34;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest2 {
    public static void main(String[] args) {
        MyService4 myService4 = new MyService4();
        MyThread myThread = new MyThread(myService4);
        MyThread2 myThread2 = new MyThread2(myService4);

        myThread.start();
        myThread2.start();
    }
}

class MyService4 {
    public ConcurrentHashMap map = new ConcurrentHashMap();

    public MyService4() {
        for (int i = 0; i < 50000; i++) {
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

class MyThread extends Thread {
    private MyService4 myService;
    public MyThread(MyService4 myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}
class MyThread2 extends Thread {
    private MyService4 myService;
    public MyThread2(MyService4 myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}