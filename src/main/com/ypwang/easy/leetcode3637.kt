package com.ypwang.easy

class Solution3637 {
    fun isTrionic(nums: IntArray): Boolean {
        if (nums[0] >= nums[1])
            return false

        var i = 1
        while (i+1 < nums.size && nums[i] < nums[i+1])
            i++

        if (i+1 == nums.size || nums[i] == nums[i+1])
            return false

        while (i+1 < nums.size && nums[i] > nums[i+1])
            i++

        if (i+1 == nums.size || nums[i] == nums[i+1])
            return false

        while (i+1 < nums.size && nums[i] < nums[i+1])
            i++

        return i+1 == nums.size
    }
}

fun main() {
    println(Solution3637().isTrionic(intArrayOf(1,3,5,4,2,6)))
}