package com.hcf.learning.demo34;

import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetTest {
    public static void main(String[] args) throws InterruptedException {
        MyService10 myService10 = new MyService10();
        MyThread10[] myArray = new MyThread10[100];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = new MyThread10(myService10);
        }
        for (int i = 0; i < myArray.length; i++) {
            myArray[i].start();
        }
        Thread.sleep(2000);
        System.out.println(myService10.set.size());
    }
}

class MyService10 {
    public static CopyOnWriteArraySet set = new CopyOnWriteArraySet();
}

class MyThread10 extends Thread {
    private MyService10 myService;

    public MyThread10(MyService10 myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            myService.set.add(Thread.currentThread().getName() + "anyString" + (i + 1));
        }
    }

}