package com.hcf.learning.demo31;

public class GroupAddAuto {
    public static void main(String[] args) {
        System.out.println("A :"+Thread.currentThread().getName()
                +" thread group :"+Thread.currentThread().getThreadGroup().getName()
        +" thread group count :"+Thread.currentThread().getThreadGroup().activeGroupCount());

        ThreadGroup newGroup = new ThreadGroup("newGroup");
        System.out.println("A :"+Thread.currentThread().getName()
                +" thread group :"+Thread.currentThread().getThreadGroup().getName()
                +" thread group count :"+Thread.currentThread().getThreadGroup().activeGroupCount());
        ThreadGroup[] threadGroups = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];

        Thread.currentThread().getThreadGroup().enumerate(threadGroups);
        for (int i = 0; i < threadGroups.length; i++) {
            System.out.println("first thread group name :"+threadGroups[i].getName());
        }
    }
}
