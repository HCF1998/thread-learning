package com.hcf.learning.demo10;

import java.util.Random;

public class ThreadPriority2 {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            MyThread4 myThread4 = new MyThread4();
            myThread4.setPriority(1);
            myThread4.start();

            MyThread5 myThread5 = new MyThread5();
            myThread5.setPriority(10);
            myThread5.start();

        }
    }
}

class MyThread4 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 50000; i++) {
                Random random = new Random();
                random.nextInt();
                addResult = addResult + i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("thread 1 use time = " + (endTime - beginTime));
    }
}

class MyThread5 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 50000; i++) {
                Random random = new Random();
                random.nextInt();
                addResult = addResult + i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("thread 2 use time = " + (endTime - beginTime));
    }
}
