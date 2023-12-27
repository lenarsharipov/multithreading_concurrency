package org.example;

import java.util.concurrent.*;

public class Ex04BlockingConcurrentCollections {
    /*
    Diff between below collections and ConcurrentLinkedDeque/ConcurrentLinkedQueue
    is small. When Blocking variants are used then it gives an opportunity for timeout with any operation.
    For real world apps, Blocking impls are preferred in most cases.
    */
    public static void main(String[] args) {
        BlockingDeque<Integer> d1 = new LinkedBlockingDeque<>();
        BlockingQueue<Integer> q1 = new LinkedBlockingQueue<>();

        d1.offer(4);

        try {
            d1.offer(4, 1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
