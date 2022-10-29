package com.hcf.learning.demo31;

public class GroupAddNewGroup {
    public static void main(String[] args) {
        System.out.println("thread group name:"+Thread.currentThread().getThreadGroup().getName());
        System.out.println("number of active thread: "+Thread.currentThread().getThreadGroup().activeCount());
        System.out.println("number of active thread group: "+Thread.currentThread().getThreadGroup().activeGroupCount());
        ThreadGroup newGroup = new ThreadGroup(Thread.currentThread().getThreadGroup(), "newGroup");
        System.out.println("after add a new group: "+Thread.currentThread().getThreadGroup().activeGroupCount());
        System.out.println("parent thread group name:"+Thread.currentThread().getThreadGroup().getParent().getName());
    }
}
