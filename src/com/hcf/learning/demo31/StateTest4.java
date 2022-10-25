package com.hcf.learning.demo31;

public class StateTest4 {
    public static void main(String[] args) {
        try {
            MyThreadE myThreadE = new MyThreadE();
            myThreadE.start();
            Thread.sleep(1000);
            System.out.println("myThreadE: " + myThreadE.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyThreadE extends Thread {
    @Override
    public void run() {
        try {
            synchronized (Lock.lock) {
                Lock.lock.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Lock {
    public static final Byte lock = new Byte("0");
}