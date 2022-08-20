package com.hcf.learning.demo24;

public class JoinTest3 {
    public static void main(String[] args) throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        Thread.currentThread().join(200,1999999);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - beginTime);
    }
}
