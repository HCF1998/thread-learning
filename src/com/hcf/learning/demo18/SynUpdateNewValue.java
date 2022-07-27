package com.hcf.learning.demo18;

public class SynUpdateNewValue {

    private boolean isContinueRun = true;

    public void runMethod(){
        // String anyString = new String();
        while(isContinueRun == true){
           // synchronized(anyString){}
        }
        System.out.println("stop");
    }

    public void stopMethod(){
        isContinueRun = false;
    }
}

class ThreadA extends Thread{
    private SynUpdateNewValue synUpdateNewValue;

    public ThreadA(SynUpdateNewValue synUpdateNewValue){
        super();
        this.synUpdateNewValue = synUpdateNewValue;
    }

    @Override
    public void run() {
        synUpdateNewValue.runMethod();
    }
}

class ThreadB extends Thread{
    private SynUpdateNewValue synUpdateNewValue;

    public ThreadB(SynUpdateNewValue synUpdateNewValue){
        super();
        this.synUpdateNewValue = synUpdateNewValue;
    }

    @Override
    public void run() {
        synUpdateNewValue.stopMethod();
    }
}

class Run1{
    public static void main(String[] args) {
        try{
            SynUpdateNewValue synUpdateNewValue = new SynUpdateNewValue();

            ThreadA threadA = new ThreadA(synUpdateNewValue);
            threadA.start();

            Thread.sleep(1000);

            ThreadB threadB = new ThreadB(synUpdateNewValue);
            threadB.start();
            System.out.println("stoped!");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}