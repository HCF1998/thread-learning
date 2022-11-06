package com.hcf.learning.demo34;

import java.util.HashMap;

public class HashMapSafeTest {
    public static void main(String[] args) {
        try{
            MyService1 myService1 = new MyService1();
            Thread1A thread1A = new Thread1A(myService1);
            Thread1B thread1B = new Thread1B(myService1);
            thread1A.start();
            thread1B.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class MyService1 {
    public HashMap map = new HashMap();

    public void testMethod() {
        for (int i = 0; i < 500000; i++) {
            map.put(Thread.currentThread().getName() + " " + (i + 1), Thread.currentThread().getName() + " " + (i + 1));
            System.out.println(Thread.currentThread().getName() + " " + (i + 1));
        }
    }
}

class Thread1A extends Thread{
    private MyService1 myService1;

    public Thread1A(MyService1 myService1) {
        super();
        this.myService1 = myService1;
    }
    @Override
    public void run(){
        myService1.testMethod();
    }
}

class Thread1B extends Thread{
    private MyService1 myService1;

    public Thread1B(MyService1 myService1) {
        super();
        this.myService1 = myService1;
    }
    @Override
    public void run(){
        myService1.testMethod();
    }
}