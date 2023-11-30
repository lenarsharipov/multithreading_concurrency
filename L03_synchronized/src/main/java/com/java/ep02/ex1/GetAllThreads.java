package com.java.ep02.ex1;

import java.util.Map;

public class GetAllThreads {
    public static void showThreads() {
        // Get all threads and their stack traces
        Map<Thread, StackTraceElement[]> allThreads = Thread.getAllStackTraces();

        // Iterate over the map entries to print thread information
        for (Map.Entry<Thread, StackTraceElement[]> entry : allThreads.entrySet()) {
            Thread thread = entry.getKey();
            StackTraceElement[] stackTrace = entry.getValue();

            System.out.println("Thread ID: " + thread.getId());
            System.out.println("Thread Name: " + thread.getName());
            System.out.println("Thread State: " + thread.getState());

            // Print stack trace elements
            for (StackTraceElement element : stackTrace) {
                System.out.println("  " + element);
            }

            System.out.println("----------------------------------------");
        }
    }
}
