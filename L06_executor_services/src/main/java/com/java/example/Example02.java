package com.java.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Example02 {
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

            // submit() defined inside the ExecutorService interface.
            // submit() more powerful method than execute().
            // it allows to call tasks which you are waiting for the result (Used Callable interface)
            // also used to check if the task is executing properly.
            // Allows to refer to the task itself outside. (Used Future interface)
            Future<?> f = service.submit(command); /* all submit() versions return Future<T or ?> interface */

            System.out.println(":( " + Thread.currentThread().getName());

        } finally {
            if (service != null) {
                service.shutdown(); // wait until all tasks are executed then service is shutdown
            }
        }
    }
}
