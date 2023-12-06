package com.java.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example01 {
    public static void main(String[] args) {
        // ExecutorService extends Executor
        ExecutorService service = null;
        try {
            int cpus = Runtime.getRuntime().availableProcessors(); // swim lanes

            service = // pool
            // ThreadPool - collection of threads. It contains threads, takes tasks and executes assigned tasks.
                    Executors.newFixedThreadPool(cpus); // threads

            // ball
            Runnable command = () -> System.out.println(":)" + Thread.currentThread().getName());

            service.execute(command); // throwing the ball into the pool

            System.out.println(":( " + Thread.currentThread().getName());

        } finally {
            if (service != null) {
                service.shutdown(); // wait until all tasks are executed then service is shutdown
            }
        }
    }
}
