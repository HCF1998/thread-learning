package com.hcf.learning.demo5;

public class DiffStartAnddRun {
    public static void main(String[] args) {
        //constructor: main
        //run(): Thread-0
        MyThread myThread = new MyThread();
        //It will create a new thread to call the start() method
        //myThread.start();
        myThread.run();
    }
}
class MyThread extends Thread {
    public MyThread(){
        System.out.println("constructor: "+Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run(): "+Thread.currentThread().getName());
    }
}