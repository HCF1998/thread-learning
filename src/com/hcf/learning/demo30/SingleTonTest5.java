package com.hcf.learning.demo30;

public class SingleTonTest5 {
}

class MyObject5 {
    private static class MyObjectHandler{
        private static MyObject5 myObject = new MyObject5();

    }
    private MyObject5(){

    }
    public static MyObject5 getInstance(){
        return MyObjectHandler.myObject;
    }
}