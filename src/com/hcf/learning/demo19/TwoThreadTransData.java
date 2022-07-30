package com.hcf.learning.demo19;

import java.util.ArrayList;
import java.util.List;

public class TwoThreadTransData {
    public static void main(String[] args) {
        MyList myList = new MyList();
        ThreadA threadA = new ThreadA(myList);
        threadA.setName("A");
        threadA.start();
        ThreadB threadB = new ThreadB(myList);
        threadB.setName("B");
        threadB.start();
    }
}

class MyList {
    volatile private List list = new ArrayList();

    public void add() {
        list.add("hcf");
    }

    public int size() {
        return list.size();
    }
}

class ThreadA extends Thread {
    private MyList list;

    public ThreadA(MyList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                list.add();
                System.out.println("add " + (i + 1) + " elements");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadB extends Thread {
    private MyList list;

    public ThreadB(MyList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (list.size() == 2) {
                    System.out.println("== 2 ,Thread B will be exit!");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}