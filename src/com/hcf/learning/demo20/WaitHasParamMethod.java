package com.hcf.learning.demo20;

public class WaitHasParamMethod {

}

class MyRunnable {
    static private Object lock = new Object();
    static private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (lock) {
                    System.out.println("wait begin time = " + System.currentTimeMillis());
                    lock.wait(5000);
                    System.out.println("end wait time = " + System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    static private Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("notify begin time = " + System.currentTimeMillis());
                lock.notify();
                System.out.println("notify wait time = " + System.currentTimeMillis());
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(3000);
        Thread thread1 = new Thread(runnable2);
        thread1.start();
    }
}