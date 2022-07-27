package com.hcf.learning.demo18;

public class RunThread extends Thread{

    //private boolean isRunning = true;
    volatile private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        System.out.println(" in run");
        while(isRunning == true){
        }
        System.out.println("thread stop");
    }
}

class Run3{
    public static void main(String[] args) {
        try{
            RunThread runThread = new RunThread();
            runThread.start();
            Thread.sleep(1000);
            runThread.setRunning(false);
            System.out.println("made it false");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}