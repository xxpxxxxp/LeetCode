package com.ypwang.easy

class Solution5130 {
    fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
        val bucket = IntArray(100)
        for (d in dominoes) {
            var (i, j) = d
            if (i > j) {
                val t = j
                j = i
                i = t
            }
            bucket[i * 10 + j]++
        }

        return bucket.filter { it > 1 }.map { it * (it - 1) / 2 }.sum()
    }
}