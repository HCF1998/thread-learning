package com.hcf.learning.demo30;

public class SingletonTest1 {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadA threadB = new ThreadA();
        ThreadA threadC = new ThreadA();
        threadA.start();
        threadB.start();
        threadC.start();
    }
}

class MyObject {
    private static MyObject myObject = new MyObject();
    //private static String A;
    //private static String B;

    public MyObject() {
    }

    public static MyObject getInstance() {
        //A = "AA";
        //B = "BB";
        return myObject;
    }
}

class ThreadA extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }
}
