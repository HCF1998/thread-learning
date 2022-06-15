package com.hcf.learning.demo6;

import java.util.Iterator;
import java.util.Map;

public class AllStackTraceTest {
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
        Map<Thread, StackTraceElement[]> allStackTraceMap = Thread.currentThread().getAllStackTraces();
        if (allStackTraceMap != null && allStackTraceMap.size() != 0) {
            Iterator<Thread> iterator = allStackTraceMap.keySet().iterator();
            while (iterator.hasNext()) {
                Thread thread = iterator.next();
                StackTraceElement[] stackTraceElements = allStackTraceMap.get(thread);
                System.out.println("Thread--");
                System.out.println("ThreadName: " + thread.getName());
                System.out.println("stackTraceElements length: " + stackTraceElements.length);
                System.out.println("Thread status: " + thread.getState());
                if (stackTraceElements.length != 0) {
                    System.out.println("stackTraceElements--");
                    for (int i = 0; i < stackTraceElements.length; i++) {
                        StackTraceElement stackTraceElement = stackTraceElements[i];
                        System.out.println("className = " + stackTraceElement.getClassName() +
                                " methodName = " + stackTraceElement.getMethodName() +
                                " fileName = " + stackTraceElement.getFileName() +
                                " lineNumber = " + stackTraceElement.getLineNumber());
                    }
                } else {
                    System.out.println("no stackTraceElment,because thread " + thread.getName() + "'s stackTraceElment[].length == 0");
                }
                System.out.println();
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        AllStackTraceTest allStackTraceTest = new AllStackTraceTest();
        allStackTraceTest.a();
    }
}
