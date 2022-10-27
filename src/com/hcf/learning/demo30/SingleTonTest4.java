package com.hcf.learning.demo30;

public class SingleTonTest4 {
    public static void main(String[] args) {
        ThreadD thread1 = new ThreadD();
        ThreadD thread2 = new ThreadD();
        ThreadD thread3 = new ThreadD();
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class MyObject4 {
    private volatile static MyObject4 myObject4;

    private MyObject4() {

    }

    public static MyObject4 getInstance() {
        try {
            if (myObject4 != null) {

            } else {
                Thread.sleep(3000);
                synchronized (MyObject4.class) {
                    if (myObject4 == null) {
                        myObject4 = new MyObject4();
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return myObject4;
    }
}

class ThreadD extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject4.getInstance().hashCode());
    }
}