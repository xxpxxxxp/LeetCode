package com.ypwang.easy

class Solution3745 {
    fun maximizeExpressionOfThree(nums: IntArray): Int {
        nums.sort()
        return nums.last() + nums[nums.lastIndex-1] - nums.first()
    }
}
