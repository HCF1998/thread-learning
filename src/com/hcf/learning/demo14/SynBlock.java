package com.hcf.learning.demo14;

public class SynBlock {
    public static void main(String[] args) {
        Task task = new Task();

        Thread1 thread1 = new Thread1(task);
        thread1.start();
        Thread2 thread2 = new Thread2(task);
        thread2.start();
    }
}

class Task {
    public void doLongTimeTask() {
        for (int i = 0; i < 100; i++) {
            System.out.println("nosynchronized threadName = " + Thread.currentThread().getName()
                    + " i= " + (i + 1));
        }
        System.out.println("");
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("synchronized threadName = " + Thread.currentThread().getName()
                        + " i = " + (i + 1));
            }
        }
    }
}

class Thread1 extends Thread {
    private Task task;

    public Thread1(Task task) {
        super();
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        task.doLongTimeTask();
    }
}
class Thread2 extends Thread {
    private Task task;

    public Thread2(Task task) {
        super();
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        task.doLongTimeTask();
    }
}