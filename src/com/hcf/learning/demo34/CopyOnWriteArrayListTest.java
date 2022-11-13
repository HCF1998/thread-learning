package com.hcf.learning.demo34;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {
    public static void main(String[] args) throws InterruptedException {
        MyService9 myService9 = new MyService9();

        MyThread9[] myArray = new MyThread9[100];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = new MyThread9(myService9);
        }
        for (int i = 0; i < myArray.length; i++) {
            myArray[i].start();
        }
        Thread.sleep(3000);
        System.out.println(myService9.list.size());
        System.out.println("get value: "+myService9.list.get(5));
    }
}

class MyService9 {
    public static CopyOnWriteArrayList list = new CopyOnWriteArrayList();
}

class MyThread9 extends Thread {
    private MyService9 myService;

    public MyThread9(MyService9 myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            myService.list.add("anyString"+Thread.currentThread().getName());
        }
    }
}