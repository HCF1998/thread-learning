package com.hcf.learning.demo36;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ExecutorsTest8SynchronousQueue {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                try{
                    System.out.println(Thread.currentThread().getName()+" run! "+System.currentTimeMillis());
                    sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(7,8,5, TimeUnit.SECONDS,new SynchronousQueue<>());
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);

        Thread.sleep(300);
        System.out.println("A executor.getCorePoolSize()="+executor.getCorePoolSize());
        System.out.println("A executor.getMaximumPoolSize()="+executor.getMaximumPoolSize());
        System.out.println("A executor.getPoolSize()="+executor.getPoolSize());
        System.out.println("A executor.getQueue().size()="+executor.getQueue().size());

        Thread.sleep(5000);

        System.out.println("after 10s");
        System.out.println("B executor.getCorePoolSize()="+executor.getCorePoolSize());
        System.out.println("B executor.getMaximumPoolSize()="+executor.getMaximumPoolSize());
        System.out.println("B executor.getPoolSize()="+ executor.getPoolSize());
        System.out.println("A executor.getQueue().size()="+executor.getQueue().size());

    }
}
