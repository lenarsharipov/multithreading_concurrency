package com.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex03 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Runnable r = () -> {
            try {
                countDownLatch.await();
                System.out.println(":)");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable q = () -> {
            try {
                Thread.sleep(2000);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(4);
        try {
            service.submit(r);
            service.submit(r);
            service.submit(r);

            service.submit(q);
            service.submit(q);
            service.submit(q);
        } finally {
            service.shutdown();
        }

    }
}
