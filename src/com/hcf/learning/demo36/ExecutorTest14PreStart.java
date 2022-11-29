package com.hcf.learning.demo36;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest14PreStart {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 8, 5,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        System.out.println("thread size = " + executor.getPoolSize());
        System.out.println("Z1 = " + executor.prestartCoreThread());
        System.out.println("thread size = " + executor.getPoolSize());
        System.out.println("Z2 = " + executor.prestartCoreThread());
        System.out.println("thread size =" + executor.getPoolSize());
        System.out.println("Z3=" + executor.prestartAllCoreThreads());
        System.out.println("thread size =" + executor.getPoolSize());
    }
}
