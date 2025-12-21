package com.ypwang.medium

class Solution3779 {
    fun minOperations(nums: IntArray): Int {
        val s = mutableSetOf<Int>()
        var i = (nums.size + 2) / 3
        while (i > 0) {
            for (j in (i - 1) * 3 until minOf(i * 3, nums.size)) {
                if (nums[j] in s)
                    return i
                s.add(nums[j])
            }
            i--
        }

        return 0
    }
}
