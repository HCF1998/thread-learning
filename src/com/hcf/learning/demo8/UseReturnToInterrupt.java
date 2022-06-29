package com.hcf.learning.demo8;

public class UseReturnToInterrupt {
    public static void main(String[] args) throws InterruptedException {
        MyThread4 myThread4 = new MyThread4();
        myThread4.start();
        Thread.sleep(1000);
        myThread4.interrupt();
    }
}

class MyThread4 extends Thread {
    @Override
    public void run() {
        while (true) {
            if (this.isInterrupted()) {
                System.out.println("interrupted!");
                return;
            }
            System.out.println("time = " + System.currentTimeMillis());
        }
    }
}
