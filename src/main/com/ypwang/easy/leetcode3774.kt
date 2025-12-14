package com.ypwang.easy

class Solution3774 {
    fun absDifference(nums: IntArray, k: Int): Int {
        nums.sort()
        return nums.takeLast(k).sum() - nums.take(k).sum()
    }
}
