package com.hcf.learning.demo31;

public class StateTest2 {
    public static void main(String[] args) {
        try {
            MyThreadB myThreadB = new MyThreadB();
            myThreadB.start();
            Thread.sleep(1000);
            System.out.println("Main method: " + myThreadB.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThreadB extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("begin sleep");
            Thread.sleep(3000);
            System.out.println("end sleep");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
