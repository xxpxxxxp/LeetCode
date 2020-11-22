package com.ypwang.easy

class Solution1662 {
    private class FlattenIterator(private val iters: Array<CharIterator>): Iterator<Char> {
        var i = 0

        override fun hasNext(): Boolean {
            if (i == iters.size)
                return false

            if (iters[i].hasNext())
                return true

            while (++i < iters.size) {
                if (iters[i].hasNext())
                    return true
            }

            return false
        }

        override fun next(): Char = iters[i].next()
    }

    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        val iter1 = FlattenIterator(word1.map { it.iterator() }.toTypedArray())
        val iter2 = FlattenIterator(word2.map { it.iterator() }.toTypedArray())

        while (iter1.hasNext()) {
            if (!iter2.hasNext() || iter1.next() != iter2.next())
                return false
        }

        if (iter2.hasNext())
            return false

        return true
    }
}