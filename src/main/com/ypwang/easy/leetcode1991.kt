package com.ypwang.easy

class Solution1991 {
    fun findMiddleIndex(nums: IntArray): Int {
        var leftSum = 0
        var rightSum = nums.sum()

        for ((i, v) in nums.withIndex()) {
            rightSum -= v
            if (leftSum == rightSum)
                return i

            leftSum += v
        }

        return -1
    }
}