package com.hcf.learning.demo9;

public class SuspendAndResumeTest {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(5000);

            myThread.suspend();
            System.out.println("A = " + System.currentTimeMillis() + " i = " + myThread.getI());
            Thread.sleep(5000);
            System.out.println("A = " + System.currentTimeMillis() + " i = " + myThread.getI());

            myThread.resume();
            Thread.sleep(5000);

            myThread.suspend();
            System.out.println("B = " + System.currentTimeMillis() + " i = " + myThread.getI());
            Thread.sleep(5000);
            System.out.println("B = " + System.currentTimeMillis() + " i = " + myThread.getI());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {

    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            i++;
        }
    }
}