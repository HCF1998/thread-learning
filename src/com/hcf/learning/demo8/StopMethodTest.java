package com.hcf.learning.demo8;

/**
 * @author changfeng.he
 */

public class StopMethodTest {
    public static void main(String[] args) {
        try {
            MyThread2 myThread = new MyThread2();
            myThread.start();
            Thread.sleep(3000);
            myThread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread2 extends Thread {
    private int i = 0;

    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i = " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
