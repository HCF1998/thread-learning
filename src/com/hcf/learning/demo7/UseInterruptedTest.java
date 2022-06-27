package com.hcf.learning.demo7;

import java.util.ArrayList;
import java.util.List;

public class UseInterruptedTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread3 myThread3 = new MyThread3();
        myThread3.start();
        boolean list1IsInterrupted = false;
        boolean list2IsInterrupted = false;

        while (myThread3.isAlive()) {
            if (Box.list1.size() > 500 && list1IsInterrupted == false) {
                myThread3.interrupt();
                list1IsInterrupted = true;
            }
            if (Box.list2.size() > 500 && list2IsInterrupted == false) {
                myThread3.interrupt();
                list2IsInterrupted = true;
            }
            Thread.sleep(50);
        }
    }
}

class Box {
    public static ArrayList list1 = new ArrayList();
    public static ArrayList list2 = new ArrayList();
}

class MyThread3 extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                if (this.isInterrupted()) {
                    throw new InterruptedException("Thread has been interrputed");
                }
                for (int i = 0; i < 1000; i++) {
                    new String("" + Math.random());
                }
                Box.list1.add("dataA");
                System.out.println("list1 size = " + Box.list1.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            while (true) {
                if (this.isInterrupted()) {
                    throw new InterruptedException("Thread has been interrputed");
                }
                for (int i = 0; i < 1000; i++) {
                    new String("" + Math.random());
                }
                Box.list2.add("dataB");
                System.out.println("list2 size = " + Box.list2.size());

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

