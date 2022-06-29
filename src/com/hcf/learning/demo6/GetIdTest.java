package com.hcf.learning.demo6;

public class GetIdTest {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        //1
        System.out.println(thread.getId());
        Thread thread1 = new Thread();
        //13
        System.out.println(thread1.getId());
    }
}
