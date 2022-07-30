package com.hcf.learning.demo19;

public class WaitTest {
    public static void main(String[] args) {
        try{
            String newString = new String("");
            newString.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
