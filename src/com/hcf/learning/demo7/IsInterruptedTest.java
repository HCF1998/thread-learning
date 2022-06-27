package com.hcf.learning.demo7;

public class IsInterruptedTest {
    public static void main(String[] args) {
        try{
            MyThread2 myThread2 = new MyThread2();
            myThread2.start();
            Thread.sleep(1000);
            myThread2.interrupt();
            //true
            //true
            System.out.println(myThread2.isInterrupted());
            System.out.println(myThread2.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
class MyThread2 extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 2000; i++) {
            System.out.println("i = " + i);
        }
    }
}