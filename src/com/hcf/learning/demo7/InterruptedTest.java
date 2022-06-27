package com.hcf.learning.demo7;

public class InterruptedTest {
    public static void main(String[] args) {
        try{
            MyThread2 myThread = new MyThread2();
            myThread.start();
            Thread.sleep(1000);
            myThread.interrupt();
            Thread.currentThread().interrupt();
            // false
            // false
            System.out.println("stop 1 ? = " + Thread.interrupted());
            System.out.println("stop 2 ? = " + myThread.interrupted());

        } catch (InterruptedException e) {
            System.out.println("main thread catch");
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 2000; i++) {
            System.out.println("i = " + i);
        }
    }
}
