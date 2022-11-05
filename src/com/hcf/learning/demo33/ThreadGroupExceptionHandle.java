package com.hcf.learning.demo33;

public class ThreadGroupExceptionHandle {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("Thread Group");
        MyThread1[] myThread1s = new MyThread1[10];
        for (int i = 0; i < myThread1s.length; i++) {
            myThread1s[i] = new MyThread1(group, "Thread-" + (i + 1), "1");
            myThread1s[i].start();
        }
        MyThread1 myThread1 = new MyThread1(group, "errorThread", "a");
        myThread1.start();
    }
}

class MyThread1 extends Thread {
    private String num;

    public MyThread1(ThreadGroup group, String name, String num) {
        super(group, name);
        this.num = num;
    }

    @Override
    public void run() {
        int numInt = Integer.parseInt(num);
        while (true) {
            System.out.println("printing: " + Thread.currentThread().getName());
        }
    }
}
