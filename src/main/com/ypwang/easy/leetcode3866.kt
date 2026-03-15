package com.ypwang.easy

class Solution3866 {
    fun firstUniqueEven(nums: IntArray): Int {
        val count = nums.groupBy { it }.mapValues { it.value.size }
        for (v in nums)
            if (v % 2 == 0 && count[v] == 1)
                return v

        return -1
    }
}
