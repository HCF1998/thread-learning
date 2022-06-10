package com.hcf.learning.demo1;

/**
 * Get the name of Current Thread and create a thread object
 */
public class GetCurrentThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("end");
        /* Will Print:
        main
        end
        My thread
         */


    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("My thread");
    }
}
