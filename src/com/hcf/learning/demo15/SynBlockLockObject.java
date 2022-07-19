package com.hcf.learning.demo15;

public class SynBlockLockObject {
    public static void main(String[] args) throws InterruptedException {
        Service1 service1 = new Service1();
        MyObject1 myObject1 = new MyObject1();

        ThreadC threadC = new ThreadC(service1, myObject1);
        threadC.setName("C");
        threadC.start();

        Thread.sleep(1000);

        ThreadD threadD = new ThreadD(myObject1);
        threadD.setName("D");
        threadD.start();
    }
}

class MyObject1 {
    synchronized public void speedPrintString() {
        System.out.println("speedPrintString()---getLock time = " + System.currentTimeMillis()
                + " run ThreadName = " + Thread.currentThread().getName());
        System.out.println("-----------");
        System.out.println("speedPrintString()---releaseLock time = " + System.currentTimeMillis()
                + " run ThreadName = " + Thread.currentThread().getName());
    }
}

class Service1 {
    public void testMethod(MyObject1 object) {
        synchronized (object) {
            try {
                System.out.println("testMethod()---getLock time = " + System.currentTimeMillis()
                        + " run ThreadName = " + Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("testMethod()---releaseLock time = " + System.currentTimeMillis()
                        + " run ThreadName = " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadC extends Thread {
    private Service1 service;
    private MyObject1 object;

    public ThreadC(Service1 service, MyObject1 object) {
        super();
        this.service = service;
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        service.testMethod(object);
    }
}

class ThreadD extends Thread {
    private MyObject1 object;

    public ThreadD(MyObject1 object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.speedPrintString();
    }
}