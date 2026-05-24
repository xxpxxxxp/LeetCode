package com.ypwang.easy

class Solution3936 {
    fun minimumSwaps(nums: IntArray): Int {
        val zs = nums.count { it == 0 }
        return zs - nums.takeLast(zs).count { it == 0 }
    }
}
