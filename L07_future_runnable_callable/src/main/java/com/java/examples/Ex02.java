package com.java.examples;

import java.util.concurrent.*;

public class Ex02 {

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            int cpus = Runtime.getRuntime().availableProcessors();
            service = Executors.newFixedThreadPool(cpus);

            // Callable has a generic type. Here it means the return value type.
            Callable<String> task = () -> "Hello!";

            // Type of Future should be the same as task has a return type
            Future<String> f = service.submit(task);

            String value = f.get();
            System.out.println(value);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            assert service != null;
            service.shutdown();
        }
    }

}
