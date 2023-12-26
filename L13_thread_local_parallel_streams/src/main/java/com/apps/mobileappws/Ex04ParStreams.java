package com.apps.mobileappws;

import java.util.List;

public class Ex04ParStreams {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);

        long t1 = System.currentTimeMillis();
        list.stream().map(n -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2 * n;
        }).forEach(System.out::println);
        System.out.println(System.currentTimeMillis() - t1);

        System.out.println("***************************");

        t1 = System.currentTimeMillis();

//        list.stream().parallel().map(n -> {
        list.parallelStream().map(n -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2 * n;
//        }).forEach(System.out::println);
        }).forEachOrdered(System.out::println);
        System.out.println(System.currentTimeMillis() - t1);
    }
}
