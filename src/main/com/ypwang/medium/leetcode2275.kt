package com.ypwang.medium

class Solution2275 {
    fun largestCombination(candidates: IntArray): Int {
        val bit = IntArray(25)
        for (i in candidates) {
            for (j in 0 until 25) {
                if (i and (1 shl j) > 0)
                    bit[j]++
            }
        }

        return bit.maxOrNull()!!
    }
}