package com.ypwang.easy

class Solution2784 {
    fun isGood(nums: IntArray): Boolean =
        nums.sorted().withIndex().all { if (it.index == nums.lastIndex) it.index == it.value else it.index + 1 == it.value }
}