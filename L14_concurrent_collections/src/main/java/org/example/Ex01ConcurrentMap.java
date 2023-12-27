package org.example;

import java.util.NavigableSet;
import java.util.concurrent.*;

public class Ex01ConcurrentMap {
    /*
    Operations of following collections are synchronized.
     */
    public static void main(String[] args) {
        ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>(); // Not ordered, not sorted

        // sorted keys. Eq with TreeMap
        ConcurrentMap<Integer, String> sorted = new ConcurrentSkipListMap<>(); // sorted

        ConcurrentNavigableMap<Integer, String> sorted2 = new ConcurrentSkipListMap<>(); // sorted

        NavigableSet<Integer> s1 = new ConcurrentSkipListSet<>(); // TreeSet (sorted)
    }
}
