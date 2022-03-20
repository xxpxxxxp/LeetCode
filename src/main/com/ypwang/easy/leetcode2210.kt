package com.ypwang.easy

class Solution2210 {
    fun countHillValley(nums: IntArray): Int {
        var r = 0
        var left = nums[0]
        for (i in 1 until nums.size - 1)
            if (left < nums[i] && nums[i] > nums[i + 1] || left > nums[i] && nums[i] < nums[i + 1]) {
                r++
                left = nums[i]
            }
        return r
    }
}

fun main() {
    println(Solution2210().countHillValley(intArrayOf(1,2,2,1)))
}