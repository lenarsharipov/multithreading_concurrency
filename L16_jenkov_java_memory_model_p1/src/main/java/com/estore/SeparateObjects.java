package com.estore;

public class SeparateObjects {
    public static void main(String[] args) {

        int myLocalVar = 0; // primitive variable is stored in Thread Stack
        String myLocalString = "Text"; // reference myLocalString is stored in Thread Stack, while string object "TEXT" is stored in HEAP.

        Runnable r1 = new MyRunnable();
        Runnable r2 = new MyRunnable();

        Thread t1 = new Thread(r1, "thread 1");
        Thread t2 = new Thread(r2, "thread 2");

        t1.start();
        t2.start();
    }
}
