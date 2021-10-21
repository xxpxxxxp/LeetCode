package com.ypwang.medium

class Solution1509 {
    fun minDifference(nums: IntArray): Int {
        if (nums.size < 5) return 0

        nums.sort()
        val k = nums.size - 4
        return (0 until nums.size - k).map {
            nums[it + k] - nums[it]
        }.minOrNull()!!
    }
}

fun main() {
    println(Solution1509().minDifference(intArrayOf(9,48,92,48,81,31)))
}