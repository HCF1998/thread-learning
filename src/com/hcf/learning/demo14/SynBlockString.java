package com.hcf.learning.demo14;

public class SynBlockString {
    public static void main(String[] args) {
        Service service = new Service();

        ThreadE threadE = new ThreadE(service);
        threadE.setName("E");
        threadE.start();

        ThreadF threadF = new ThreadF(service);
        threadF.setName("F");
        threadF.start();
    }
}

class Service {
    private String usernameParam;
    private String passwordParam;
    //private String anyString = new String();

    public void setUsernamePassword(String username, String password) {
        try {
            String anyString = new String();
            synchronized (anyString) {
                System.out.println("Thread name: " + Thread.currentThread().getName() + " join in at " + System.currentTimeMillis());
                usernameParam = username;
                Thread.sleep(3000);
                passwordParam = password;
                System.out.println("Thread name: " + Thread.currentThread().getName() + " leave a " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadE extends Thread {
    private Service service;

    public ThreadE(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.setUsernamePassword("e", "ee");
    }
}

class ThreadF extends Thread {
    private Service service;

    public ThreadF(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.setUsernamePassword("f", "ff");
    }
}
