package com.java.examples;

import java.util.concurrent.*;

public class Ex03 {

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            int cpus = Runtime.getRuntime().availableProcessors();
            service = Executors.newFixedThreadPool(cpus);
            Callable<Integer> task = new SummingNumbersCallable(1, 10);
            Future<Integer> f = service.submit(task);

            int sum = f.get();
            System.out.println(sum);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            assert service != null;
            service.shutdown();
        }
    }

}
