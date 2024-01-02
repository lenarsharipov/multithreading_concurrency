package com.estore;

public class SharedObjects {
    public static void main(String[] args) {
        Runnable r1 = new MyRunnable();

        Thread t1 = new Thread(r1, "thread 1");
        Thread t2 = new Thread(r1, "thread 2");

        t1.start();
        t2.start();
    }
}