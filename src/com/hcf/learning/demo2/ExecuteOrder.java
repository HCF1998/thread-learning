package com.hcf.learning.demo2;

public class ExecuteOrder {
    public static void main(String[] args) {
        MyThread t1 = new MyThread(1);
        MyThread t2 = new MyThread(2);
        MyThread t3 = new MyThread(3);
        MyThread t4 = new MyThread(4);
        MyThread t5 = new MyThread(5);
        MyThread t6 = new MyThread(6);
        MyThread t7 = new MyThread(7);
        MyThread t8 = new MyThread(8);
        /*
         * print order: 12543687
         */
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
    }
}
class MyThread extends Thread{
    private int i;
    public MyThread(int i){
        super();
        this.i = i;
    }
    @Override
    public void run() {
        System.out.println(i);
    }
}