package com.ll.exam;

import java.util.AbstractMap;
import java.util.Map;

class Pair {
    // Return a map entry (key-value pair) from the specified values
    public static <T, U> Map.Entry<T, U> of(T first, U second) {
        return new AbstractMap.SimpleEntry<>(first, second);
    }
}
