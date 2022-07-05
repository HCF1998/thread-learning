package com.hcf.learning.demo10;

public class YieldTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000; i++) {
            Thread.yield();
            count = count + (i + 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("time cost: " + (endTime - beginTime));
    }
}