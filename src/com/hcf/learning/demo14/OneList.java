package com.hcf.learning.demo14;

import java.util.ArrayList;
import java.util.List;

public class OneList {
    private List list = new ArrayList();

    synchronized public void add(String data) {
        list.add(data);
    }

    synchronized public int getSize() {
        return list.size();
    }
}

class MyService {
    public OneList addServiceMethod(OneList list, String data) {
        try {
            synchronized (list) {
                if (list.getSize() < 1) {
                    Thread.sleep(2000);
                    list.add(data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }
}

class ThreadI extends Thread {
    private OneList oneList;

    public ThreadI(OneList oneList) {
        super();
        this.oneList = oneList;
    }

    @Override
    public void run() {
        MyService myService = new MyService();
        myService.addServiceMethod(oneList, "I");
    }
}

class ThreadJ extends Thread {
    private OneList oneList;

    public ThreadJ(OneList oneList) {
        super();
        this.oneList = oneList;
    }

    @Override
    public void run() {
        MyService myService = new MyService();
        myService.addServiceMethod(oneList, "J");
    }
}

class Run4 {
    public static void main(String[] args) throws InterruptedException {
        OneList oneList = new OneList();

        ThreadI threadI = new ThreadI(oneList);
        threadI.setName("I");
        threadI.start();

        ThreadJ threadJ = new ThreadJ(oneList);
        threadJ.setName("");
        threadJ.start();

        Thread.sleep(5000);
        System.out.println("listSize = " + oneList.getSize());

    }
}