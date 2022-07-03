package com.hcf.learning.demo9;

public class DealLock2 {
    public static void main(String[] args) {
        try{
            MyThread1 myThread1 = new MyThread1();
            myThread1.start();
            Thread.sleep(1000);
            myThread1.suspend();
            System.out.println("main end!");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread1 extends Thread {

    private long i = 0;

    @Override
    public void run() {
        while (true) {
            i++;
            System.out.println(i);
        }
    }
}
