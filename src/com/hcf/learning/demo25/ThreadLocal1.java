package com.hcf.learning.demo25;

public class ThreadLocal1 {
    public static ThreadLocal t1 = new ThreadLocal();

    public static void main(String[] args) {
        if (t1.get()==null){
            System.out.println("t1 get null");
            t1.set("t1 value");
        }
        System.out.println(t1.get());
    }
}
