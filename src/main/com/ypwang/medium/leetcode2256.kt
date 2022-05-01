package com.ypwang.medium

class Solution2256 {
    fun minimumAverageDifference(nums: IntArray): Int {
        var idx = 0
        var min = Long.MAX_VALUE

        var left = 0L
        var right = nums.fold(0L) { a, b -> a + b }
        for ((i, v) in nums.withIndex()) {
            right -= v
            left += v
            val lavg = left / (i + 1)
            val ravg = if (i == nums.lastIndex) 0 else right / (nums.size - i - 1)
            val diff = Math.abs(lavg - ravg)
            if (diff < min) {
                idx = i
                min = diff
            }
        }

        return idx
    }
}

fun main() {
    println(Solution2256().minimumAverageDifference(intArrayOf(1,1,1,1,1)))
}