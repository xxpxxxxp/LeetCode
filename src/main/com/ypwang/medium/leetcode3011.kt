package com.ypwang.medium

class Solution3011 {
    fun canSortArray(nums: IntArray): Boolean {
        var preMax = Int.MIN_VALUE
        var min = nums[0]
        var max = nums[0]
        var cur = nums[0].countOneBits()
        for (i in 1 until nums.size) {
            if (nums[i].countOneBits() == cur) {
                min = minOf(min, nums[i])
                max = maxOf(max, nums[i])
            } else {
                if (min < preMax)
                    return false
                preMax = max
                min = nums[i]
                max = nums[i]
                cur = nums[i].countOneBits()
            }
        }

        return min >= preMax
    }
}

fun main() {
    println(Solution3011().canSortArray(intArrayOf(3,16,8,4,2)))
    println(Solution3011().canSortArray(intArrayOf(8,4,2,30,15)))
}