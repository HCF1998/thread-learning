package com.hcf.learning.demo8;

public class ThreadDeathExceptionTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread3 myThread3 = new MyThread3();
        myThread3.start();
        Thread.sleep(1000);
        try {
            myThread3.stop();
        } catch (ThreadDeath e) {
            System.out.println("Main catch");
            e.printStackTrace();
        }
    }
}

class MyThread3 extends Thread {
    @Override
    public void run() {
        //try {
            for (int i = 0; i < 5000000; i++) {
                System.out.println(i + 1);
            }
        //} catch (ThreadDeath e) {
        //    e.printStackTrace();
        //    System.out.println("MyThead catch");
        //}
    }
}