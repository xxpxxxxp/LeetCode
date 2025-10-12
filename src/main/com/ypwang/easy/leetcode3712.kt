package com.ypwang.easy

class Solution3712 {
    fun sumDivisibleByK(nums: IntArray, k: Int): Int =
        nums.groupBy { it }
            .mapValues { it.value.size }
            .filter { it.value % k == 0 }
            .map { it.key * it.value }
            .sum()
}
