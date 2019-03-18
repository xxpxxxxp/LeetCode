package com.ypwang.medium;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> inner;
    private Integer cur;
    private Boolean cached;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        inner = iterator;
        cached = false;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (cached) {
            return cur;
        }
        if (!inner.hasNext()) {
            return null;
        }
        cur = inner.next();
        cached = true;
        return cur;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (cached) {
            cached = false;
            return cur;
        } else {
            return inner.next();
        }
    }

    @Override
    public boolean hasNext() {
        if (cached) {
            return true;
        } else {
            return inner.hasNext();
        }
    }
}