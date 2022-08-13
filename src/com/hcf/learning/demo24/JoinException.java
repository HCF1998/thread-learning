package com.hcf.learning.demo24;

public class JoinException {
    public static void main(String[] args) {
        try{
            ThreadB threadB = new ThreadB();
            threadB.start();

            Thread.sleep(500);
            ThreadC threadC = new ThreadC(threadB);
            threadC.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String newStrig = new String();
            Math.random();
        }
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        try {
            ThreadA threadA = new ThreadA();
            threadA.start();
            threadA.join();
            System.out.println("ThreadB printed");
        } catch (InterruptedException e) {
            System.out.println("ThreadB catch");
            e.printStackTrace();
        }
    }
}

class ThreadC extends Thread {
    private ThreadB threadB;

    public ThreadC(ThreadB threadB) {
        super();
        this.threadB = threadB;
    }

    @Override
    public void run() {
        threadB.interrupt();
    }
}