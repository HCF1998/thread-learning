package com.hcf.learning.demo24;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        //Thread.sleep(?)
        System.out.println("Need to sleep how long?");
        myThread.join();
        System.out.println("After join");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            int secondValue = (int) (Math.random() * 10000);
            System.out.println(secondValue);
            Thread.sleep(secondValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

