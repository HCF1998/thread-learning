package com.hcf.learning.demo31;

public class StateTest3 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadC myThreadC = new MyThreadC();
        myThreadC.setName("C");
        myThreadC.start();
        Thread.sleep(1000);
        MyThreadD myThreadD = new MyThreadD();
        myThreadD.setName("D");
        myThreadD.start();
        Thread.sleep(1000);
        System.out.println("threadD state in main method "+myThreadD.getState());
    }
}
class MyService{
    synchronized static public void serviceMethod(){
        try{
            System.out.println(Thread.currentThread().getName()+" call service method");
            Thread.sleep(4000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThreadC extends Thread {
    @Override
    public void run() {
        MyService.serviceMethod();
    }
}

class MyThreadD extends Thread {
    @Override
    public void run() {
        MyService.serviceMethod();
    }
}