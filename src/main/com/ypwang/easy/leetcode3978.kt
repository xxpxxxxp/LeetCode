package com.ypwang.easy

class Solution3978 {
    fun isMiddleElementUnique(nums: IntArray): Boolean =
        nums.count { it == nums[(nums.size-1)/2] } == 1
}
