package com.hcf.learning.demo19;
public class WaitInterrupt {
    public static void main(String[] args) {
        try{
            Object lock = new Object();
            ThreadI threadI = new ThreadI(lock);
            threadI.start();

            Thread.sleep(5000);

            threadI.interrupt();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Service3{
    public void testsMethod(Object lock){
        try{
            synchronized (lock) {
                System.out.println("begin wait()");
                lock.wait();
                System.out.println("end wait()");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("throw exception, because the thread has been interrupted when it is waiting.");
        }
    }

}

class ThreadI extends Thread {
    private Object lock;

    public ThreadI(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        Service3 service3 = new Service3();
        service3.testsMethod(lock);
    }
}