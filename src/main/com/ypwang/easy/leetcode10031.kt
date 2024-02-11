package com.ypwang.easy

class Solution100031 {
    fun missingInteger(nums: IntArray): Int {
        var i = 0
        var sum = nums[0]
        while (i < nums.lastIndex && nums[i]+1 == nums[i+1]) {
            sum += nums[i+1]
            i++
        }

        val all = nums.toSet()
        while (sum in all)
            sum++

        return sum
    }
}