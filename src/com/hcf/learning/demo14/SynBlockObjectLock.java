package com.hcf.learning.demo14;

public class SynBlockObjectLock {
    public static void main(String[] args) throws InterruptedException {
        Task2 task2 = new Task2();

        MyThread5 myThread5 = new MyThread5(task2);
        myThread5.start();

        Thread.sleep(100);

        MyThread6 myThread6 = new MyThread6(task2);
        myThread6.start();
    }
}

class Task2 {
    synchronized public void otherMethod() {
        System.out.println("---run-otherMethod");
    }

    public void doLongTimeTask() {
        synchronized (this) {
            for (int i = 0; i < 10000; i++) {
                System.out.println("synchronized threadName = " + Thread.currentThread().getName()
                        + " i=" + (i + 1));
            }
        }
    }
}

class MyThread5 extends Thread {
    private Task2 task2;

    public MyThread5(Task2 task2) {
        super();
        this.task2 = task2;
    }

    @Override
    public void run() {
        super.run();
        task2.doLongTimeTask();
    }
}
class MyThread6 extends Thread {
    private Task2 task2;

    public MyThread6(Task2 task2) {
        super();
        this.task2 = task2;
    }

    @Override
    public void run() {
        super.run();
        task2.otherMethod();
    }
}