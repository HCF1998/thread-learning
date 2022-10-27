package com.hcf.learning.demo30;

public class SingleTonTest2 {
    public static void main(String[] args) {
        ThreadB threadA = new ThreadB();
        ThreadB threadB = new ThreadB();
        ThreadB threadC = new ThreadB();
        threadA.start();
        threadB.start();
        threadC.start();
    }
}

class MyObject2 {
    private static MyObject2 myObject;

    private MyObject2() {

    }

    //synchronized
    public static MyObject2 getInstance() {
        if (myObject != null) {
        } else {
            myObject = new MyObject2();
        }
        return myObject;
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject2.getInstance().hashCode());
    }
}