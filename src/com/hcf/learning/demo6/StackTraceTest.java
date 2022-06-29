package com.hcf.learning.demo6;

public class StackTraceTest {
    void a() {
        b();
    }
    void b() {
        c();
    }
    void c() {
        d();
    }
    void d() {
        e();
    }
    void e() {
        StackTraceElement[] stackTraces = Thread.currentThread().getStackTrace();
        if (stackTraces != null) {
            for (int i = 0; i < stackTraces.length; i++) {
                StackTraceElement stackTraceElement = stackTraces[i];
                System.out.println("className = " + stackTraceElement.getClassName() +
                        " methodName = " + stackTraceElement.getMethodName() +
                        " fileName = " + stackTraceElement.getFileName() +
                        " lineNumber = " + stackTraceElement.getLineNumber());
            }
        }
    }
    public static void main(String[] args) {
        StackTraceTest stackTraceTest = new StackTraceTest();
        stackTraceTest.a();
    }
}
