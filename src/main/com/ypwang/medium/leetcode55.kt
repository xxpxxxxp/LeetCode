package com.ypwang.medium

class Solution55 {
    fun canJump(nums: IntArray): Boolean {
        if (nums.isEmpty()) {
            return true
        }

        var index = nums.lastIndex

        for (i in nums.lastIndex - 1 downTo 0) {
            if (nums[i] >= index - i) {
                index = i
            }
        }

        return index == 0
    }
}

fun main() {
    println(Solution55().canJump(intArrayOf(3,2,1,0,4)))
}