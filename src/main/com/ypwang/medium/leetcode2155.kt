package com.ypwang.medium

class Solution2155 {
    fun maxScoreIndices(nums: IntArray): List<Int> {
        val s0 = nums.count { it == 0 }
        val s1 = nums.size - s0

        val idx = mutableListOf(0)
        var max = s1
        var c0 = 0
        var c1 = 0
        for ((i, v) in nums.withIndex()) {
            when (v) {
                0 -> c0++
                1 -> c1++
            }

            val s = c0 + s1 - c1
            if (s == max)
                idx.add(i+1)
            else if (s > max) {
                idx.clear()
                idx.add(i+1)
                max = s
            }
        }

        return idx
    }
}