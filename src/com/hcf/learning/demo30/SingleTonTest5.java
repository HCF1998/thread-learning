package com.hcf.learning.demo30;

public class SingleTonTest5 {
}

class MyObject4{
    private static class MyObjectHandler{
        private static MyObject4 myObject = new MyObject4();

    }
    private MyObject4(){

    }
    public static MyObject4 getInstance(){
        return MyObjectHandler.myObject;
    }
}