package com.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex01 {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);

        Runnable r = () -> {
            try {
                barrier.await();
                System.out.println(":)");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(3);
        try {
            service.submit(r);
            service.submit(r);
            service.submit(r);
        } finally {
            service.shutdown();
        }

    }

}
