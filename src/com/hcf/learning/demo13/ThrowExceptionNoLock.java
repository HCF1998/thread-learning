package com.hcf.learning.demo13;

public class ThrowExceptionNoLock {
    synchronized public void testMethod() {
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("ThreadName = " + Thread.currentThread().getName()
                    + " run beginTime = " + System.currentTimeMillis());

            int i = 1;
            while (i == 1) {
                if (("" + Math.random()).substring(0, 8).equals("0.123456")) {
                    System.out.println("ThreadName = " + Thread.currentThread().getName()
                            + " run exceptionTime = " + System.currentTimeMillis());
                    Integer.parseInt("a");
                }
            }
        } else {
            System.out.println("Thread B run Time = " + System.currentTimeMillis());
        }
    }
}

class ThreadA extends Thread {
    private ThrowExceptionNoLock throwExceptionNoLock;

    public ThreadA(ThrowExceptionNoLock throwExceptionNoLock) {
        super();
        this.throwExceptionNoLock = throwExceptionNoLock;
    }

    @Override
    public void run() {
        throwExceptionNoLock.testMethod();
    }
}

class ThreadB extends Thread {
    private ThrowExceptionNoLock throwExceptionNoLock;

    public ThreadB(ThrowExceptionNoLock throwExceptionNoLock) {
        super();
        this.throwExceptionNoLock = throwExceptionNoLock;
    }

    @Override
    public void run() {
        throwExceptionNoLock.testMethod();
    }
}

class Run4 {
    public static void main(String[] args) {
        try {
            ThrowExceptionNoLock throwExceptionNoLock = new ThrowExceptionNoLock();
            ThreadA threadA = new ThreadA(throwExceptionNoLock);
            threadA.setName("a");
            threadA.start();

            Thread.sleep(500);

            ThreadB threadB = new ThreadB(throwExceptionNoLock);
            threadB.setName("b");
            threadB.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}