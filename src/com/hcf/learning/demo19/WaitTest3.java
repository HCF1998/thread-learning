package com.hcf.learning.demo19;

public class WaitTest3 {
    public static void main(String[] args) {
        Object lock = new Object();

        ThreadE threadE = new ThreadE(lock);
        threadE.start();
        ThreadF threadF = new ThreadF(lock);
        threadF.start();
    }
}

class Service {
    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait()");
                //sleep(): will no release the lock
                lock.wait();
                System.out.println("end wait()");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadE extends Thread {
    private Object lock;

    public ThreadE(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }
}

class ThreadF extends Thread {
    private Object lock;

    public ThreadF(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }
}
