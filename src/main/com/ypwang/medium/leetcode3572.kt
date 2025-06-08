package com.ypwang.medium

class Solution3572 {
    fun maxSumDistinctTriplet(x: IntArray, y: IntArray): Int {
        val p = x.zip(y).sortedByDescending { it.second }

        val seen = mutableSetOf<Int>()
        var rst = 0
        for ((a, b) in p) {
            if (a !in seen) {
                seen.add(a)
                rst += b
            }

            if (seen.size == 3)
                return rst
        }

        return -1
    }
}
