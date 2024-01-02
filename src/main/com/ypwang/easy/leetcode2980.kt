package com.ypwang.easy

class Solution2980 {
    fun hasTrailingZeros(nums: IntArray): Boolean =
        nums.count { it and 0x1 == 0 } > 1
}