package com.test;

import java.util.concurrent.*;

public class Ex02 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Runnable r = () -> {
            try {
                countDownLatch.countDown();
                countDownLatch.await();
                System.out.println(":)");
            } catch (InterruptedException e) {
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
