package com.hcf.learning.demo18;

public class LongDouble32NoAtomic {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        ThreadC threadC = new ThreadC(service);
        ThreadD threadD = new ThreadD(service);
        threadC.start();
        threadD.start();
        Thread.sleep(1000);
        System.out.println("long 1 : " + Long.toBinaryString(1));
        System.out.println("long -1 : " + Long.toBinaryString(-1));
        while (true) {
            long getValue = service.i;
            if (getValue != 1 && getValue != -1) {
                System.out.println(" i : "+Long.toBinaryString(getValue) + " or "+getValue);
                System.exit(0);
            }
        }
    }
}

class Service {
    public long i;
}

class ThreadC extends Thread {
    private Service service;

    public ThreadC(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        while (true) {
            service.i = 1;
        }
    }
}

class ThreadD extends Thread {
    private Service service;

    public ThreadD(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        while (true) {
            service.i = -1;
        }
    }
}

