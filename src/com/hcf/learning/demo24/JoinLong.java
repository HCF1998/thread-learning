package com.hcf.learning.demo24;

public class JoinLong {
    public static void main(String[] args) {
        try{
            MyThread2 myThread2 = new MyThread2();
            myThread2.start();
            System.out.println("main begin time = "+System.currentTimeMillis());
            //myThread2.join(2000);
            myThread2.join(8000);
            System.out.println("main end time = "+System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        try{
            System.out.println("run begin time = "+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("run end time = "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}