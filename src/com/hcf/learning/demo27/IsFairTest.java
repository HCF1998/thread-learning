package com.hcf.learning.demo27;

import java.util.concurrent.locks.ReentrantLock;

public class IsFairTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        ReentrantLock reentrantLock1 = new ReentrantLock(false);
        ReentrantLock reentrantLock2 = new ReentrantLock();
        System.out.println(reentrantLock.isFair());
        System.out.println(reentrantLock1.isFair());
        System.out.println(reentrantLock2.isFair());
    }
}
