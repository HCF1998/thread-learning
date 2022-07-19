package com.hcf.learning.demo15;

public class SynBlockLockAll {
}

class Run{
    public static void main(String[] args) {
        Service service = new Service();
        MyObject myObject = new MyObject();

        ThreadA threadA = new ThreadA(service, myObject);
        threadA.setName("A");
        threadA.start();
        ThreadB threadB = new ThreadB(service, myObject);
        threadB.setName("B");
        threadB.start();
    }
}

class Run1{
    public static void main(String[] args) {
        Service service = new Service();
        MyObject myObject1 = new MyObject();
        MyObject myObject2 = new MyObject();

        ThreadA threadA = new ThreadA(service, myObject1);
        threadA.setName("A");
        threadA.start();
        ThreadB threadB = new ThreadB(service, myObject2);
        threadB.setName("B");
        threadB.start();
    }
}
class MyObject {

}

class Service {
    public void testMethod1(MyObject object) {
        synchronized (object) {
            try {
                System.out.println("testMethod1 getLock time = " + System.currentTimeMillis()
                        + " run ThreadName = " + Thread.currentThread().getName());

                Thread.sleep(2000);
                System.out.println("testMethod1 releaseLock time = " + System.currentTimeMillis()
                        + "run ThreadName = " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadA extends Thread {
    private Service service;
    private MyObject object;

    public ThreadA(Service service, MyObject object) {
        super();
        this.service = service;
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        service.testMethod1(object);
    }
}

class ThreadB extends Thread {
    private Service service;
    private MyObject object;

    public ThreadB(Service service, MyObject object) {
        super();
        this.service = service;
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        service.testMethod1(object);
    }
}