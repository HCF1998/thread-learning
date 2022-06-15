package com.hcf.learning.demo6;

public class DumpStackTest
{
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
        int age = 0;
        age = 100;
        if (age == 100) {
            Thread.dumpStack();
        }
    }
    public static void main(String[] args) {
        DumpStackTest dumpStack = new DumpStackTest();
        dumpStack.a();
    }
}
