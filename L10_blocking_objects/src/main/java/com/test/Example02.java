package com.test;

import java.util.concurrent.Semaphore;

public class Example02 {
    private final Semaphore semaphore = new Semaphore(4, true);  // 4 threads allowed. Fair Semaphore.

    public static void main(String[] args) {
        // Semaphore -> synchronizations
    }

    public void m() {

        // t1, t2, t3, t4, t5, t6  ...
        try {
            semaphore.acquire(); // Order is preserved. FIFO. As Semaphore fair.
            // Only 4 threads allowed: t2, t3, t4, t5
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            // t1
        }

    }
}
