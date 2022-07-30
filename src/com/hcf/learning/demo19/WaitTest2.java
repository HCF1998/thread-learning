package com.hcf.learning.demo19;

public class WaitTest2 {
    public static void main(String[] args) {
        try {
            String lock = new String();
            System.out.println("before syn");
            synchronized (lock) {
                System.out.println("first line");
                lock.wait();
                System.out.println("second line");
            }
            System.out.println("after syn");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
