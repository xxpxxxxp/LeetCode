package com.ypwang.medium

class Solution2059 {
    fun minimumOperations(nums: IntArray, start: Int, goal: Int): Int {
        val dp = BooleanArray(1001)
        dp[start] = true

        var step = 0
        var set = setOf(start)
        while (set.isNotEmpty()) {
            step++
            val next = set.flatMap { n ->
                nums.flatMap { d ->
                    listOf(n + d, n - d, n xor d)
                }
            }.toSet()

            if (goal in next)
                return step

            set = next.filter { it in 0..1000 }.filter {
                if (dp[it])
                    false
                else {
                    dp[it] = true
                    true
                }
            }.toSet()
        }

        return -1
    }
}