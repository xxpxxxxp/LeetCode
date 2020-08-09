package com.ypwang.medium

class Solution1546 {
    fun maxNonOverlapping(nums: IntArray, target: Int): Int {
        val dp = IntArray(nums.size+1){0}

        val map = mutableMapOf(0 to 0)
        var sum = 0
        for ((i, n) in nums.withIndex()) {
            sum += n
            if (sum - target in map)
                dp[i+1] = maxOf(dp[i+1], dp[map[sum - target]!!] + 1)

            map[sum] = i+1
            dp[i+1] = maxOf(dp[i], dp[i+1])
        }

        return dp.last()
    }
}

fun main() {
    println(Solution1546().maxNonOverlapping(intArrayOf(1,1,1,1,1), 2))
    println(Solution1546().maxNonOverlapping(intArrayOf(-1,3,5,1,4,2,-9), 6))
    println(Solution1546().maxNonOverlapping(intArrayOf(-2,6,6,3,5,4,1,2,8), 10))
    println(Solution1546().maxNonOverlapping(intArrayOf(0,0,0), 0))
}