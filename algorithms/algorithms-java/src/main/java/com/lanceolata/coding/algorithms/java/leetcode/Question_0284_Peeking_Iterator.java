package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Iterator;

public class Question_0284_Peeking_Iterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer cache;

    public Question_0284_Peeking_Iterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (cache != null) {
            return cache;
        }
        cache = iterator.next();
        return cache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res;
        if (cache != null) {
            res = cache;
            cache = null;
        } else {
            res = iterator.next();
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return cache != null || iterator.hasNext();
    }
}
