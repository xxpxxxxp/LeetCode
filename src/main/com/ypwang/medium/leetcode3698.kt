package com.ypwang.medium

class Solution3698 {
    fun splitArray(nums: IntArray): Long {
        var j = 0
        var lSum = 0L
        while (j < nums.size - 1 && nums[j] < nums[j+1])
            lSum += nums[j++]

        var x = nums.lastIndex
        var rSum = 0L
        while (x > 0 && nums[x-1] > nums[x])
            rSum += nums[x--]

        if (x - j > 1)
            return -1

        return if (x != j) Math.abs(lSum + nums[j] - rSum - nums[x])
        else minOf(Math.abs(lSum + nums[x] - rSum), Math.abs(lSum - nums[x] - rSum))
    }
}

fun main() {
    println(Solution3698().splitArray(intArrayOf(2,4)))
    println(Solution3698().splitArray(intArrayOf(2,2)))
    println(Solution3698().splitArray(intArrayOf(1,3,2)))
    println(Solution3698().splitArray(intArrayOf(1,2,4,3)))
}
