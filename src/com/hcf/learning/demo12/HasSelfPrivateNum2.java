package com.hcf.learning.demo12;

public class HasSelfPrivateNum2 {

    private int num = 0;
    public void addI(String username) {
        try {
            if (username.equals("c")) {
                num = 100;
                System.out.println("c set over");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("d set over");
            }
            System.out.println(username + " num = " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreadC extends Thread {
    private HasSelfPrivateNum2 numRef;

    public ThreadC(HasSelfPrivateNum2 numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("c");
    }
}

class ThreadD extends Thread {
    private HasSelfPrivateNum2 numRef;

    public ThreadD(HasSelfPrivateNum2 numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("d");
    }
}

class Run2 {
    public static void main(String[] args) {
        HasSelfPrivateNum2 numRef = new HasSelfPrivateNum2();

        ThreadC threadC = new ThreadC(numRef);
        threadC.start();

        ThreadD threadD = new ThreadD(numRef);
        threadD.start();
    }
}