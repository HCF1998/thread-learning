package com.hcf.learning.demo33;

public class ThreadExceptionMove {
    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        myThread3.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());
        myThread3.setDefaultUncaughtExceptionHandler(new StateUncaughtExcaptionHandler());
        myThread3.start();
    }
}

class MyThread3 extends Thread {
    private String num = "a";

    public MyThread3() {
        super();
    }

    public MyThread3(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        int numInt = Integer.parseInt(num);
        System.out.println("thread print: " + (numInt + 1));
    }
}

class MyThreadGroup3 extends ThreadGroup {
    public MyThreadGroup3(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        super.uncaughtException(t, e);
        System.out.println("Thread group exception handler");
        e.printStackTrace();
    }
}

class ObjectUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Object exception handler");
        e.printStackTrace();
    }
}

class StateUncaughtExcaptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("State exception handler");
    }
}