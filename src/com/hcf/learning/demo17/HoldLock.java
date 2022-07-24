package com.hcf.learning.demo17;

public class HoldLock {
    public static void main(String[] args) {
        System.out.println("A " + Thread.currentThread().holdsLock(HoldLock.class));
        synchronized (HoldLock.class) {
            System.out.println("B " + Thread.currentThread().holdsLock(HoldLock.class));
        }
        System.out.println("C " + Thread.currentThread().holdsLock(HoldLock.class));
    }
}
