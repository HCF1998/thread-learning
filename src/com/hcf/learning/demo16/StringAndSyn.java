package com.hcf.learning.demo16;

public class StringAndSyn {
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA threadA = new ThreadA(service, "A");
        threadA.start();
        ThreadB threadB = new ThreadB(service, "B");
        threadB.start();
    }
}
class Service{
    public static void print(String stringParam){
        try{
            synchronized(stringParam){
                while(true){
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA extends Thread {
    private Service service;
    public ThreadA(Service service,String name) {
        super();
        this.setName(name);
        this.service = service;
    }
    @Override
    public void run() {
        service.print("AA");
    }
}
class ThreadB extends Thread {
    private Service service;
    public ThreadB(Service service, String name) {
        super();
        this.setName(name);
        this.service = service;
    }
    @Override
    public void run() {
        service.print("AA");
    }
}