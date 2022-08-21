package com.hcf.learning.demo25;

public class ThreadLocal3 {
    public static ThreadLocalExt t1 = new ThreadLocalExt();

    public static void main(String[] args) {
        if (t1.get() == null){
            System.out.println("null value");
            t1.set("My Value");
        }
        System.out.println(t1.get());
    }
}

class ThreadLocalExt extends ThreadLocal {
    @Override
    protected Object initialValue() {
        return "not null";
    }
}
