package com.hcf.learning.demo11;

public class DaemonThread {
    public static void main(String[] args) {
        try{
            MyThread myThread = new MyThread();
            myThread.setDaemon(true);
            myThread.start();
            Thread.sleep(5000);
            System.out.println("thread doesn't print");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MyThread extends Thread {
    private int i = 0;
    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i = " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
