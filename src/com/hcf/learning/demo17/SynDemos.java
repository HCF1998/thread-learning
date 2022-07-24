package com.hcf.learning.demo17;

public class SynDemos {
    synchronized public static void testMethod1(){}

    public void testMethod2(){
        synchronized(SynDemos.class){

        }
    }

    synchronized public void testMethod3(){}

    public void testMethod4(){
        synchronized(this){

        }
    }

    public void testMethod5(){
        synchronized ("abc"){

        }
    }
}
