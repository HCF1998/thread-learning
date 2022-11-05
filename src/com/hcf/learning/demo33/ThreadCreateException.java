package com.hcf.learning.demo33;

public class ThreadCreateException {
    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        myThread.start();
        // handler the exception
        MyThread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                                                        @Override
                                                        public void uncaughtException(Thread t, Throwable e) {
                                                            System.out.println("thread: " + t.getName() + " throw an exception");
                                                            e.printStackTrace();
                                                        }
                                                    }
        );

        MyThread myThread = new MyThread();
        myThread.setName("myThread1");
//        myThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread t, Throwable e) {
//                System.out.println("thread: " + t.getName() + " throw an exception");
//                e.printStackTrace();
//            }
//        });
        myThread.start();

        MyThread myThread1 = new MyThread();
        myThread1.setName("myThread1");
        myThread1.start();

    }
}


class MyThread extends Thread {
    @Override
    public void run() {
        String username = null;
        System.out.println(username.hashCode());
    }
}