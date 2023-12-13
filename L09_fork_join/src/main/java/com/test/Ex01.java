package com.test;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * ForkJoinPool -> thread pool
 *
 * Task -> T1(T1.1, T1.2), T2(T2.1, T2.2)
 *
 * -> RecursiveAction  -----------> Runnable(returns void)
 * -> RecursiveTask<T> -----------> Callable<T>(returns value)
 *
 * Scenario: having a list, print in the console the values from the list doubled.
 *          [1, 2, 3, 4, 5, 6, 7, 8, 9]
 *
 *          [1, 2, 3, 4], [5, 6, 7, 8, 9]
 *
 *          [1, 2], [3, 4], [5, 6], [7, 8, 9]
 *
 *          [1, 2], [3, 4], [5, 6], [7], [8, 9]
 */
public class Ex01 {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        pool.invoke(new DoubleNumbersRecursiveAction(input));
    }

}

class DoubleNumbersRecursiveAction extends RecursiveAction {
    private final List<Integer> input;

    public DoubleNumbersRecursiveAction(List<Integer> input) {
        this.input = input;
    }

    @Override
    protected void compute() {
        if (input.size() <= 2) {
            input.stream().map(n -> 2 * n).forEach(System.out::println);
        } else {
            int middle = input.size() / 2;
            List<Integer> first = input.subList(0, middle);             // [0, middle)
            List<Integer> second = input.subList(middle, input.size()); // [middle, input.size())

            DoubleNumbersRecursiveAction task1 = new DoubleNumbersRecursiveAction(first);
            DoubleNumbersRecursiveAction task2 = new DoubleNumbersRecursiveAction(second);

            invokeAll(task1, task2);
        }
    }
}