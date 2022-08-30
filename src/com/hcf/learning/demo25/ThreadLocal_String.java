package com.hcf.learning.demo25;

public class ThreadLocal_String {
    public static void main(String[] args) throws InterruptedException {
        if (Tools2.t1.get() == null) {
            Tools2.t1.set("set by main");
        }
        System.out.println("get by main " + Tools.t1.get());
        Thread.sleep(100);
        ThreadC threadC = new ThreadC();
        threadC.start();
        Thread.sleep(500);
        Tools2.t1.set("new set by main");
    }
}

class Tools2 {
    public static InheritableThreadLocal t1 = new InheritableThreadLocal();
}

class ThreadC extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("ThreadC: " + Tools2.t1.get());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}