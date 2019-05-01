package com.ypwang.medium;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    private Iterator<NestedInteger> member;
    Iterator<Integer> cur;

    public NestedIterator(List<NestedInteger> nestedList) {
        member = nestedList.iterator();
        cur = null;
    }

    @Override
    public Integer next() {
        return cur.next();
    }

    private boolean roll() {
        if (member.hasNext()) {
            NestedInteger n = member.next();
            cur = n.isInteger() ?
                    Collections.singletonList(n.getInteger()).iterator() :
                    new NestedIterator(n.getList());
            return true;
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        if (cur == null) {
            while (roll()) {
                if (cur.hasNext()) {
                    return true;
                }
            }
            return false;
        }

        if (!cur.hasNext()) {
            while (roll()) {
                if (cur.hasNext()) {
                    return true;
                }
            }
            return false;
        }

        return true;
    }
}