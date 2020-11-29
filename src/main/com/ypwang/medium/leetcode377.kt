package com.ypwang.medium

class Solution377 {
    fun combinationSum4(nums: IntArray, target: Int): Int {
        val dp = IntArray(target + 1){0}
        dp[0] = 1
        for (i in 1..target) {
            for (num in nums) {
                if (i >= num)
                    dp[i] += dp[i-num]
            }
        }

        return dp.last()
    }
}

fun main() {
    println(Solution377().combinationSum4(intArrayOf(3,33,333), 10000))
}