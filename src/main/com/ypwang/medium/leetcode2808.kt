package com.ypwang.medium

class Solution2808 {
    fun minimumSeconds(nums: List<Int>): Int {
        val pos = mutableMapOf<Int, Int>()
        val gap = mutableMapOf<Int, Int>()

        for ((i, v) in (nums + nums).withIndex()) {
            if (v in pos)
                gap[v] = maxOf(gap.getOrDefault(v, 0), (i - pos[v]!!) / 2)
            pos[v] = i
        }

        return gap.values.min()
    }
}