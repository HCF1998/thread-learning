package com.hcf.learning.demo9;

public class DealLock {
    public static void main(String[] args) {
        try{
            final SynObject object = new SynObject();
            Thread thread = new Thread() {
                @Override
                public void run() {
                    object.printString();
                }
            };
            thread.setName("a");
            thread.start();
            Thread.sleep(1000);

            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    System.out.println("thread1 begin");
                    object.printString();
                }
            };
            thread1.start();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SynObject{
    synchronized public void printString(){
        System.out.println("begin");
        if(Thread.currentThread().getName().equals("a")){
            System.out.println("a suspend");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }
}