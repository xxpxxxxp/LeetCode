package com.ypwang.medium

class Solution2202 {
    fun maximumTop(nums: IntArray, k: Int): Int {
        if (nums.isEmpty() || (nums.size == 1 && k % 2 == 1))
            return -1

        return when (k) {
            0 -> nums.first()
            1 -> nums[1]
            else -> {
                var m = nums.take(k-1).maxOrNull()!!
                if (nums.size > k)
                    m = maxOf(m, nums[k])

                m
            }
        }
    }
}