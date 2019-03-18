package com.ypwang.medium

class Solution75 {
    fun sortColors(nums: IntArray): Unit {
        var i = 0
        var j = 0
        var n = nums.lastIndex

        while (j <= n) {
            when {
                nums[j] < 1 -> {
                    val t = nums[i]
                    nums[i] = nums[j]
                    nums[j] = t
                    i++
                    j++
                }
                nums[j] > 1 -> {
                    val t = nums[n]
                    nums[n] = nums[j]
                    nums[j] = t
                    n--
                }
                else -> {
                    j++
                }
            }
        }
    }
}