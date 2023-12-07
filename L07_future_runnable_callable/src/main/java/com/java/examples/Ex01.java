package com.java.examples;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex01 {
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            int cores = Runtime.getRuntime().availableProcessors();
            System.out.println(cores);
            service = Executors.newFixedThreadPool(cores);

            Runnable command = () -> System.out.println(":)");

            Future<?> f = service.submit(command);

            // do other operations

            f.get();
            // if not ready, you have to wait
            // if ready returns the value

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            assert service != null;
            service.shutdown();
        }
    }

}
