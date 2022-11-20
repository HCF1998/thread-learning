package com.hcf.learning.demo36;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MyRunnable((" "+(i+1))));
        }
    }
}

class MyRunnable implements Runnable{
    private String username;
    public MyRunnable(String username){
        super();
        this.username = username;
    }

    @Override
    public void run() {
        try{
            System.out.println(Thread.currentThread().getName()+" username="+username+" begin "+System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+" username="+username+" end "+System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();

        }
    }
}