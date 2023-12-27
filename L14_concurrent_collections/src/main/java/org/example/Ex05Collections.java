package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Ex05Collections {

    /*
    Following methods are accepting non-concurrent collections
    and returns collection which is then synchronized.
    */
    public static void main(String[] args) {
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> sm1 = Collections.synchronizedMap(m1);

        ConcurrentHashMap<Integer, Integer> m2 = new ConcurrentHashMap<>(); // try to use special concurrent collections
    }
}
