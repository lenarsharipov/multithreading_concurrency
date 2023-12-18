package com.test;

import java.util.concurrent.Semaphore;

public class Example01 {

    private final Semaphore semaphore = new Semaphore(4);  // 4 threads allowed. NonFair Semaphore

    public static void main(String[] args) {
        // Semaphore -> synchronizations
    }

    public void m() {

        // t1, t2, t3, t4, t5, t6  ...
        try {
            semaphore.acquire();
            // Only 4 threads allowed: t2, t3, t4, t5
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            // t1
        }

    }
}