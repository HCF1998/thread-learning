package com.hcf.learning.demo30;

public class SingletonTest7 {
}
class MyObject7 {
    private static MyObject7 instance = null;

    private MyObject7(){

    }

    static {
        instance = new MyObject7();
    }

    public static MyObject7 getInstance(){
        return instance;
    }
}

