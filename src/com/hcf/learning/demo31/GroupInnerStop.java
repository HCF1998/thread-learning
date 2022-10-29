package com.hcf.learning.demo31;

public class GroupInnerStop {
    public static void main(String[] args) {
        try {
            ThreadGroup group = new ThreadGroup("My Group");
            for (int i = 0; i < 5; i++) {
                MyThread myThread = new MyThread(group, "thread" + (i + 1));
                myThread.start();
            }
            Thread.sleep(5000);
            group.interrupt();
            System.out.println("call interrupt()");
        } catch (InterruptedException e) {
            System.out.println("stoped");
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {
    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        System.out.println("ThreadName = " + Thread.currentThread().getName() + " begin");
        while (!this.isInterrupted()) {

        }
        System.out.println("ThreadName = " + Thread.currentThread().getName() + " stop");
    }
}
