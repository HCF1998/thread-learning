package com.hcf.learning.demo12;
public class HasSelfPrivateNum3 {
    synchronized public void testMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + " begin: " + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " end: " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreadE extends Thread {
    private HasSelfPrivateNum3 numRef;

    public ThreadE(HasSelfPrivateNum3 numRef) {
        super();
        this.numRef = numRef;
    }
    @Override
    public void run() {
        super.run();
        numRef.testMethod();
    }
}
class ThreadF extends Thread {
    private HasSelfPrivateNum3 numRef;

    public ThreadF(HasSelfPrivateNum3 numRef) {
        super();
        this.numRef = numRef;
    }
    @Override
    public void run() {
        super.run();
        numRef.testMethod();
    }
}
class Run3{
    public static void main(String[] args) {
        HasSelfPrivateNum3 hasSelfPrivateNum1 = new HasSelfPrivateNum3();
        HasSelfPrivateNum3 hasSelfPrivateNum2 = new HasSelfPrivateNum3();
        ThreadE threadE = new ThreadE(hasSelfPrivateNum1);
        threadE.start();
        ThreadF threadf = new ThreadF(hasSelfPrivateNum2);
        threadf.start();
    }
}