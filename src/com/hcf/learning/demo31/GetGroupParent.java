package com.hcf.learning.demo31;

public class GetGroupParent {
    public static void main(String[] args) {
        System.out.println("Thread :"+Thread.currentThread().getName()
                +" belong to thread group :"+Thread.currentThread().getThreadGroup().getName());
        System.out.println("The parent of main thread group :"+Thread.currentThread().getThreadGroup().getParent().getName());

        System.out.println("The root thread group :"+Thread.currentThread().getThreadGroup().getParent().getParent().getName());
    }
}
