package com.hcf.learning.demo12;

public class SynchronizedMethodLockObject {
    synchronized public void methodA() {
        try {
            System.out.println("begin methodA threadName = " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("endA,endTime = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //synchronized
    public void methodB() {
        try {
            System.out.println("begin methodB threadName = " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("endB,,endTime = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadG extends Thread {
    private SynchronizedMethodLockObject object;

    public ThreadG(SynchronizedMethodLockObject object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}

class ThreadH extends Thread {
    private SynchronizedMethodLockObject object;

    public ThreadH(SynchronizedMethodLockObject object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}

class ThreadI extends Thread {
    private SynchronizedMethodLockObject object;

    public ThreadI(SynchronizedMethodLockObject object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodB();
    }
}

class Run1 {
    public static void main(String[] args) {
        SynchronizedMethodLockObject o = new SynchronizedMethodLockObject();

        ThreadG threadG = new ThreadG(o);
        threadG.setName("G");
        ThreadH threadH = new ThreadH(o);
        threadH.setName("H");
        threadG.start();
        threadH.start();

        ThreadI threadI = new ThreadI(o);
        threadI.setName("I");
        threadI.start();
    }
}