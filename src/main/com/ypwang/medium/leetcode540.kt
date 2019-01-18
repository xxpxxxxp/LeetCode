package com.ypwang.medium

class Solution540 {
    fun helper(nums: IntArray, start: Int, end: Int): Int {
        if (start == end) {
            return nums[start]
        }

        val mid = start + (end - start) / 2
        val rightLen = end - mid

        if (nums[mid] != nums[mid+1]) {
            if (rightLen % 2 == 0) {
                return helper(nums, start, mid)
            } else {
                return helper(nums, mid+1, end)
            }
        } else {
            if (rightLen % 2 == 0) {
                return helper(nums, mid, end)
            } else {
                return helper(nums, start, mid-1)
            }
        }
    }

    fun singleNonDuplicate(nums: IntArray): Int {
        return helper(nums, 0, nums.lastIndex)
    }
}

fun main(args: Array<String>) {
    println(Solution540().singleNonDuplicate(intArrayOf(1,1,2,3,3,4,4,8,8)))
}