package com.test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FibonacciCalculator {

    public static int simpleCalculator(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return simpleCalculator(n - 1) + simpleCalculator(n - 2);
        }
    }

    public static void main(String[] args) {
        int input = 5;
        System.out.println(simpleCalculator(input));

        System.out.println("*".repeat(50));

        ForkJoinPool pool = new ForkJoinPool();
        int result = pool.invoke(new ForkJoinFibonacciCalculator(input));
        System.out.println(result);
    }
}

class ForkJoinFibonacciCalculator extends RecursiveTask<Integer> {
    private final int input;

    public ForkJoinFibonacciCalculator(int input) {
        this.input = input;
    }

    @Override
    protected Integer compute() {
        if (input <= 1) {
            return 1;
        }

        int left = input - 1;
        int right = input - 2;

        var t1 = new ForkJoinFibonacciCalculator(left);
        var t2 = new ForkJoinFibonacciCalculator(right);

        t2.fork();

        return t1.compute() + t2.join();
    }
}