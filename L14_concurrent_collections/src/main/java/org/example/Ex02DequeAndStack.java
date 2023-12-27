package org.example;

import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Ex02DequeAndStack {
    /*
    Operations of following collections are synchronized.
     */
    public static void main(String[] args) {
        Deque<Integer> d1 = new ConcurrentLinkedDeque<>(); // ordered
        Queue<Integer> q1 = new ConcurrentLinkedQueue<>(); // ordered

    }
}
