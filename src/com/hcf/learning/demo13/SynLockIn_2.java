package com.hcf.learning.demo13;

public class SynLockIn_2 {
    public int i = 10;
    synchronized public void operateIMainMethod(){
        try{
            i--;
            System.out.println("main print i = "+i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Sub extends SynLockIn_2{
    synchronized public void operateIMainMethod(){
        try{
            while(i>0){
                i--;
                System.out.println("sub print i="+i);
                Thread.sleep(100);
                super.operateIMainMethod();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        Sub sub = new Sub();
        sub.operateIMainMethod();
    }
}

class Run2{
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
    }
}