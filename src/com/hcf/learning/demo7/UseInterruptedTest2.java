package com.hcf.learning.demo7;

public class UseInterruptedTest2 {

    public static void main(String[] args) throws InterruptedException {
        MyThread4 myThread = new MyThread4();
        myThread.start();
        boolean list1IsInterrupted = false;
        boolean list2IsInterrupted = false;
        while (myThread.isAlive()) {
            if (Box.list1.size() > 500 && list1IsInterrupted == false) {
                myThread.interrupt();
                list1IsInterrupted = true;
            }
            if (Box.list2.size() > 600 && list2IsInterrupted == false) {
                myThread.interrupt();
                list2IsInterrupted = true;
            }
            Thread.sleep(100);
        }
    }
}

class MyThread4 extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                if (this.interrupted()) {
                    throw new InterruptedException("the thread has been interrupted");
                }
                for (int i = 0; i < 1000; i++) {
                    new String("" + Math.random());
                }

                Box.list1.add("data A");
                System.out.println("list1 size = " + Box.list1.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            while (true) {
                if (this.interrupted()) {
                    throw new InterruptedException("the thread has been interrupted");
                }
                for (int i = 0; i < 1000; i++) {
                    new String("" + Math.random());
                }

                Box.list2.add("data B");
                System.out.println("list2 size = " + Box.list2.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}