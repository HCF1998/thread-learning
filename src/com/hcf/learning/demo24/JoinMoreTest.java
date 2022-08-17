package com.hcf.learning.demo24;

public class JoinMoreTest {
    public static void main(String[] args) {
        try{
            ThreadE threadE = new ThreadE();
            ThreadD threadD = new ThreadD(threadE);
            threadD.start();
            threadE.start();
            threadE.join(200);
            System.out.println("main end "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadD extends Thread {
    private ThreadE threadE;

    public ThreadD(ThreadE threadE) {
        super();
        this.threadE = threadE;
    }

    @Override
    public void run() {
        try {
            synchronized (threadE) {
                System.out.println("begin ThreadName =  " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(500);
                System.out.println("end Thread =  " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreadE extends Thread {
    @Override
    synchronized public void run() {
        try{
            System.out.println("begin2 ThreadName = "+Thread.currentThread().getName()+" "+System.currentTimeMillis());
            Thread.sleep(500);
            System.out.println("end2 Thread =  " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}