package com.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyTask implements Runnable {
    private CyclicBarrier barrier;

    public MyTask() {
        barrier = new CyclicBarrier(3);
    }

    @Override
    public void run() {
        try {
            barrier.await(); // barrier blocks threads
            System.out.println(":)");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

}