package com.hcf.learning.demo33;

public class ThreadGroupExceptionHandle1 {
    public static void main(String[] args) {
        MyThreadGroup group = new MyThreadGroup("threadGroup");
        MyThread2[] myThread2s = new MyThread2[10];
        for (int i = 0; i < myThread2s.length; i++) {
            myThread2s[i] = new MyThread2(group,"Thread-"+(i+1),"1");
            myThread2s [i].start();
        }
        MyThread2 myThread2 = new MyThread2(group, "error Thread", "a");
        myThread2.start();
    }
}

class MyThreadGroup extends ThreadGroup {
    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        super.uncaughtException(t, e);
        this.interrupt();
    }
}

class MyThread2 extends Thread {
    private String num;

    public MyThread2(ThreadGroup group, String name, String num) {
        super(group, name);
        this.num = num;
    }

    @Override
    public void run() {
        int numInt = Integer.parseInt(num);
        while (this.isInterrupted() == false){
            System.out.println("thread: "+Thread.currentThread().getName());
        }
    }
}