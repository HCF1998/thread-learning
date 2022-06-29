package com.hcf.learning.demo8;

public class InterrupetUnderSleepStatus {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(200);
            myThread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();

        try {
            System.out.println("run begin");
            Thread.sleep(200000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("be interrupted when in sleeping: " + this.isInterrupted());
            e.printStackTrace();
        }
    }
}
