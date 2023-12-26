package com.apps.mobileappws;

import java.util.stream.Stream;

public class Ex05ParStreams {
    /**
     * Here values are printed in consequences order inspite of using parallel;
     * @param args
     */
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .parallel() // obtains parallel streams. It creates threads pool
                .forEachOrdered(n -> System.out.println(Thread.currentThread().getName() + " " + n)); // not it executed by several different threads
    }

}
