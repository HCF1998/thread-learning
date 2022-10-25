package com.hcf.learning.demo31;

public class StateTest1 {
    public static void main(String[] args) {
        try{
            MyThreadA myThreadA = new MyThreadA();
            System.out.println("Main method: "+myThreadA.getState());
            Thread.sleep(1000);
            myThreadA.start();
            System.out.println("Main method2: "+myThreadA.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyThreadA extends Thread {
    public MyThreadA() {
        System.out.println("Constructor method: " + Thread.currentThread().getState());
    }

    @Override
    public void run() {
        System.out.println("Run method: " + Thread.currentThread().getState());
    }
}
