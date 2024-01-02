package com.estore;

public class MyRunnable implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        Object obj = new Object();
        System.out.println(
                Thread.currentThread().getName() + " : " + obj
        );

        for (int i = 0; i < 1_000_000; i++) {
            this.count++;
        }
        System.out.println(
                Thread.currentThread().getName() + " : " + this.count
        );
    }
}
