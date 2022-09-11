package com.ypwang.medium

class Solution2405 {
    fun partitionString(s: String): Int {
        val set = mutableSetOf<Char>()
        var count = 1

        for (c in s) {
            if (c in set) {
                set.clear()
                count++
            } else {
                set.add(c)
            }
        }

        return count
    }
}