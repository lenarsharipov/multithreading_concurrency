package com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex01 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3); // Here threads number must be equal
        // or more tanh the number of parties used in the barrier, otherwise deadlock appears
        try {
            var task = new MyTask();
            service.submit(task);
            service.submit(task);
            service.submit(task);
            service.submit(task);
        } finally {
            service.shutdown();
        }

    }
}
