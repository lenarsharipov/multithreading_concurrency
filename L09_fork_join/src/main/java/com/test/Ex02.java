package com.test;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoinPool -> thread pool
 *
 * Task -> T1(T1.1, T1.2), T2(T2.1, T2.2)
 *
 * -> RecursiveTask<T> -----------> Callable<T>(returns value)
 *
 * Scenario: having a list, return the sum of all elements.
 *          [1, 2, 3, 4, 5, 6] ====> 21
 */
public class Ex02 {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        int res = pool.invoke(new SumNumbersRecursiveTask(input));
        System.out.println(res);
    }
}

class SumNumbersRecursiveTask extends RecursiveTask<Integer> {

    private final List<Integer> input;

    public SumNumbersRecursiveTask(List<Integer> input) {
        this.input = input;
    }

    @Override
    protected Integer compute() {
        if (input.size() <= 2) {
            return input.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
        } else {
            int middle = input.size() / 2;
            List<Integer> first = input.subList(0, middle);
            List<Integer> second = input.subList(middle, input.size());

            SumNumbersRecursiveTask task1 = new SumNumbersRecursiveTask(first);
            SumNumbersRecursiveTask task2 = new SumNumbersRecursiveTask(second);

            task2.fork(); // task1 to be executed on separate thread

            return task1.compute() + task2.join();
        }
    }
}
