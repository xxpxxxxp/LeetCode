package com.ypwang.easy

class Solution2644 {
    fun maxDivScore(nums: IntArray, divisors: IntArray): Int =
        divisors.maxWith(compareBy<Int> { d -> nums.count { it % d == 0 } }.thenByDescending { it })
}
