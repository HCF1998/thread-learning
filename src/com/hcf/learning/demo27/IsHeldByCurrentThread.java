package com.hcf.learning.demo27;

import java.util.concurrent.locks.ReentrantLock;

public class IsHeldByCurrentThread {
    public static void main(String[] args) {
        final Service3 service = new Service3();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.serviceMethod();
            }
        };
        new Thread(runnable).start();
    }
}
class Service3{
    private ReentrantLock lock = new ReentrantLock();
    public void serviceMethod(){
        try{
            System.out.println(lock.isHeldByCurrentThread());
            lock.lock();
            System.out.println(lock.isHeldByCurrentThread());
        }finally{
            lock.unlock();
        }
    }
}