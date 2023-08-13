package com.ypwang.medium

import java.util.*

class Solution2817 {
    fun minAbsoluteDifference(nums: List<Int>, x: Int): Int {
        var ans = Int.MAX_VALUE
        val nm = TreeSet<Int>()
        for (i in x until nums.size) {
            nm.add(nums[i - x])
            val sm = nm.ceiling(nums[i])
            if (sm != null)
                ans = minOf(ans, Math.abs(nums[i] - sm))
            val bg = nm.floor(nums[i])
            if (bg != null) {
                ans = minOf(ans, Math.abs(nums[i] - bg))
            }
        }
        return ans
    }
}