package com.hcf.learning.demo27;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class HasWaitersTest {
    public static void main(String[] args) throws InterruptedException {
        final Service2 service = new Service2();
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                service.waitMethod();
            }
        };
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(runnable);
        }
        for (int i = 0; i <10;i++){
            threads[i].start();
        }
        Thread.sleep(2000);
        service.notifyMethod();
    }
}


class Service2 {
    private ReentrantLock lock = new ReentrantLock();
    private Condition newCondition = lock.newCondition();

    public void waitMethod() {
        try {
            lock.lock();
            newCondition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void notifyMethod() {
        try {
            lock.lock();
            System.out.println("waiting condition: " + lock.hasWaiters(newCondition) + ",threads = " + lock.getWaitQueueLength(newCondition));
            newCondition.signal();
        } finally {
            lock.unlock();
        }
    }

}