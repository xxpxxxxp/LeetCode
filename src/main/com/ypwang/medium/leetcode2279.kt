package com.ypwang.medium

class Solution2279 {
    fun maximumBags(capacity: IntArray, rocks: IntArray, additionalRocks: Int): Int {
        val remaining = capacity.zip(rocks).map { (a, b) -> a - b }.sorted()
        var rs = additionalRocks
        var rst = 0
        for (r in remaining) {
            if (rs < r)
                break

            rs -= r
            rst++
        }
        return rst
    }
}