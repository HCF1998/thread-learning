package com.hcf.learning.demo31;

public class GroupAddThread {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        ThreadGroup threadGroup = new ThreadGroup("Thread Group");
        Thread aThread = new Thread(threadGroup, threadA);
        Thread bThread = new Thread(threadGroup, threadB);

        aThread.start();
        bThread.start();

        System.out.println("active thread: " + threadGroup.activeCount());
        System.out.println("thread group name: " + threadGroup.getName());
    }
}

class ThreadA extends Thread {
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("ThreadName = " + Thread.currentThread().getName());
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class ThreadB extends Thread {
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("ThreadName = " + Thread.currentThread().getName());
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}