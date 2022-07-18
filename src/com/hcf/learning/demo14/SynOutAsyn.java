package com.hcf.learning.demo14;

import java.util.ArrayList;
import java.util.List;

public class SynOutAsyn {

    public static void main(String[] args) {
        MyList myList = new MyList();

        ThreadG threadG = new ThreadG(myList);
        threadG.setName("G");
        threadG.start();

        ThreadH threadH = new ThreadH(myList);
        threadH.setName("H");
        threadH.start();
    }
}

class MyList {
    private List list = new ArrayList();

    synchronized public void add(String username) {
        System.out.println("ThreadName = " + Thread.currentThread().getName() + " add()");
        list.add(username);
        System.out.println("ThreadName = " + Thread.currentThread().getName() + " out of add()");
    }

    synchronized public int getSizes() {
        System.out.println("ThreadName = " + Thread.currentThread().getName() + " getSize()");
        int sizeValue = list.size();
        System.out.println("ThreadName = " + Thread.currentThread().getName() + "  out of getSize()");
        return sizeValue;
    }
}

class ThreadG extends Thread {
    private MyList list;

    public ThreadG(MyList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            list.add("threadG" + (i + 1));
        }
    }
}

class ThreadH extends Thread {
    private MyList list;

    public ThreadH(MyList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            list.add("threadH" + (i + 1));
        }
    }
}