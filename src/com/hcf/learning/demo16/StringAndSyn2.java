package com.hcf.learning.demo16;

public class StringAndSyn2 {
    public static void main(String[] args) {
        Service2 service2 = new Service2();
        ThreadC c = new ThreadC(service2, "C");
        c.start();
        ThreadD d = new ThreadD(service2, "D");
        d.start();
    }
}

class Service2 {
    public static void print(Object object) {
        try {
            synchronized (object) {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadC extends Thread {
    private Service2 service;

    public ThreadC(Service2 service, String name) {
        super();
        this.setName(name);
        this.service = service;
    }

    @Override
    public void run() {
        service.print(new Object());
    }
}

class ThreadD extends Thread {
    private Service2 service;

    public ThreadD(Service2 service, String name) {
        super();
        this.setName(name);
        this.service = service;
    }

    @Override
    public void run() {
        service.print(new Object());
    }
}
