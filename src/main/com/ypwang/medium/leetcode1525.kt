package com.ypwang.medium

class Solution1525 {
    fun numSplits(s: String): Int {
        val positive = s.groupBy { it }.mapValues { it.value.size }.toMutableMap()
        val negative = mutableSetOf<Char>()

        var rst = 0
        for (c in s) {
            val i = positive[c]!!
            if (i - 1 == 0) positive.remove(c)
            else positive[c] = i-1

            negative.add(c)
            if (positive.size == negative.size)
                rst++
        }

        return rst
    }
}