package com.hcf.learning.demo18;

public class PrintString2 implements Runnable{
    private boolean isContinuePrint = true;

    public boolean isContinuePrint(){
        return isContinuePrint;
    }

    public void setContinuePrint(boolean isContinuePrint){
        this.isContinuePrint = isContinuePrint;
    }

    public void printStringMethod(){
        try{
            while (isContinuePrint == true){
                System.out.println("run printStringMethod threadName = "+Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        printStringMethod();
    }
}

class Run2{
    public static void main(String[] args) {
        PrintString2 printString = new PrintString2();
        new Thread(printString).start();
        System.out.println("stop "+Thread.currentThread().getName());
        printString.setContinuePrint(false);
    }
}
