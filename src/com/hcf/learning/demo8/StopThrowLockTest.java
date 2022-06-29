package com.hcf.learning.demo8;

public class StopThrowLockTest {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        MyThreadA myThreadA = new MyThreadA(myService);
        MyThreadB myThreadB = new MyThreadB(myService);
        myThreadA.start();
        Thread.sleep(5000);
        myThreadB.start();
        System.out.println(" begin " + System.currentTimeMillis());
        Thread.sleep(5000);
        myThreadA.stop();
    }
}

class MyService {

    private String username = "a";
    private String password = "aa";

    synchronized public String getUsername() {
        return username;
    }

    synchronized public String getPassword() {
        return password;
    }

    synchronized public void printString(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(1000000);
            this.password = password;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThreadA extends Thread {
    private MyService service;

    public MyThreadA(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.printString("b", "b");
    }
}

class MyThreadB extends Thread {

    private MyService service;

    public MyThreadB(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        System.out.println(service.getUsername() + " " + service.getPassword());
        System.out.println(" end " + System.currentTimeMillis());
    }
}

