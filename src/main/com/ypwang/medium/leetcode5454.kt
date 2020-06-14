package com.ypwang.medium

class Solution5454 {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        val uniques = arr.groupBy { it }.mapValues { it.value.size }.toList().sortedBy { it.second }
        var removed = 0
        var c = k
        for ((_, v) in uniques) {
            if (v <= c)
                removed++

            c -= v

            if (c <= 0)
                break
        }

        return uniques.size - removed
    }
}