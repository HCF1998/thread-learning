package com.hcf.learning.demo27;

import java.util.concurrent.locks.ReentrantLock;

public class IsLocked {
    public static void main(String[] args) {
        final MyService2 service = new MyService2();
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                service.serviceMethod();
            }
        };
        new Thread(runnable).start();
    }
}
class MyService2{
    private ReentrantLock lock = new ReentrantLock();

    public void serviceMethod(){
        try{
            System.out.println(lock.isLocked());
            lock.lock();
            System.out.println(lock.isLocked());
        }finally {
            lock.unlock();
        }
    }
}
