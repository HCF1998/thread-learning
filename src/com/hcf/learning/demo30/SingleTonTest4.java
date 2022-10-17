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

class MyObject3 {
    private volatile static MyObject3 myObject3;

    private MyObject3() {

    }

    public static MyObject3 getInstance() {
        try {
            if (myObject3 != null) {

            } else {
                Thread.sleep(3000);
                synchronized (MyObject3.class) {
                    if (myObject3 == null) {
                        myObject3 = new MyObject3();
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return myObject3;
    }
}

class ThreadD extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject3.getInstance().hashCode());
    }
}