package com.hcf.learning.demo18;

public class VolatileTest {
    public static void main(String[] args) {
        MyThread[] myThreads = new MyThread[100];
        for (int i = 0; i < 100; i++) {
            myThreads[i] = new MyThread();
        }
        for (int i = 0; i < 100; i++) {
            myThreads[i].start();
        }
    }
}

class MyThread extends Thread {
    volatile public static int count;

    //synchronized
    private static void addCount() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count: " + count);
    }

    @Override
    public void run() {
        addCount();
    }
}