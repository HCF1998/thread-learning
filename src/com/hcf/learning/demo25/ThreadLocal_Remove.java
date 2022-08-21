package com.hcf.learning.demo25;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocal_Remove {
    public static void main(String[] args) {
        for (int i = 0; i < 900; i++) {
            MyThreadLocal myThreadLocal = new MyThreadLocal();
            UserInfo userInfo = new UserInfo();
            myThreadLocal.set(userInfo);
            //myThreadLocal.remove();
        }
        MyThreadLocal myThreadLocal = new MyThreadLocal();
        System.out.println("end!");
        List list = new ArrayList();
        for (int i = 0; i < 900000000; i++){
            String s = new String("" + (i + 1));
            Thread.yield();
            Thread.yield();
            Thread.yield();
            Thread.yield();
            Thread.yield();
        }
        System.out.println("zzzzzzzzzzzzz"+myThreadLocal);
    }
}

class MyThreadLocal extends ThreadLocal {
    private static AtomicInteger count = new AtomicInteger(0);

    @Override
    protected void finalize() throws Throwable {
        System.out.println("MyThread finalize() " + count.addAndGet(1));
    }
}

class UserInfo {
    private static AtomicInteger count = new AtomicInteger(0);

    @Override
    protected void finalize() throws Throwable {
        System.out.println("---UserInfo---" + count.addAndGet(1));
    }
}