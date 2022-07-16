package com.hcf.learning.demo14;

public class DoubleSynBlockOneTwo {
    public static void main(String[] args) {
        ObjectService objectService = new ObjectService();
        ThreadC threadC = new ThreadC(objectService);
        threadC.setName("c");
        threadC.start();
        ThreadD threadD = new ThreadD(objectService);
        threadD.setName("d");
        threadD.start();
    }
}

class ObjectService {
    public void serviceMethodA() {
        try {
            synchronized (this) {
                System.out.println("A begin time = " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A end time= " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodB() {
        synchronized (this) {
            System.out.println("B begin time= " + System.currentTimeMillis());
            System.out.println("B end time=" + System.currentTimeMillis());
        }
    }
}

class ThreadC extends Thread {
    private ObjectService objectService;

    public ThreadC(ObjectService objectService) {
        super();
        this.objectService = objectService;
    }

    @Override
    public void run() {
        super.run();
        objectService.serviceMethodA();
    }
}

class ThreadD extends Thread {
    private ObjectService objectService;

    public ThreadD(ObjectService objectService) {
        super();
        this.objectService = objectService;
    }

    @Override
    public void run() {
        super.run();
        objectService.serviceMethodB();
    }
}
