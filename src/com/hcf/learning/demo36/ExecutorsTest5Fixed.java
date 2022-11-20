package com.hcf.learning.demo36;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest5Fixed {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0;i<3;i++){
            executorService.execute(new MyRunnable3((""+ (i + 1))));
        }
        for (int i = 0; i <3; i++){
            executorService.execute(new MyRunnable3((""+ (i + 1))));
        }
    }
}
class MyRunnable3 implements Runnable{
    private String username;
    public MyRunnable3(String username) {
        super();
        this.username = username;
    }
    @Override
    public void run() {
        try{
            System.out.println(Thread.currentThread().getName()+" username=" + username +" begin "+ System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+" username=" + username +" end "+System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
