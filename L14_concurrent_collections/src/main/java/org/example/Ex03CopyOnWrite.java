package org.example;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Ex03CopyOnWrite {
    /*
    operations of following collections not synchronized.
    Only used when there are more READ operations than WRITE operations.
     */
    public static void main(String[] args) {
        // Any kind of mutating operation(add, change, delete) on following collections
        // creates a new instance of the collection which copies all values again.
        // Operation is executed on the copy.
        // There should be very cautious with these collections,
        // as if there are a lot of mutation operations
        // memory could be exhausted fast
        List<Integer> list = new CopyOnWriteArrayList<>();

        Set<Integer> set = new CopyOnWriteArraySet<>();

    }
}
