package com.ypwang.easy

class Solution1403 {
    fun minSubsequence(nums: IntArray): List<Int> {
        val part = 1 + nums.sum() / 2

        nums.sortDescending()
        var sum = 0
        var idx = 0
        while (sum < part)
            sum += nums[idx++]

        return nums.slice(IntRange(0, idx-1))
    }
}

fun main() {
    println(Solution1403().minSubsequence(intArrayOf(4,3,10,9,8)))
    println(Solution1403().minSubsequence(intArrayOf(4,4,7,6,7)))
}