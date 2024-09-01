package com.ypwang.hard

class Solution3277 {
    fun maximumSubarrayXor(nums: IntArray, queries: Array<IntArray>): IntArray {
        val n = nums.size
        val dp = Array(n) { IntArray(n) }

        for (i in 0 until n)
            dp[i][i] = nums[i]

        for (len in 2..n) {
            for (st in 0 until n - len + 1) {
                val end = st + len - 1
                dp[st][end] = dp[st][end - 1] xor dp[st + 1][end]
            }
        }

        for (len in 2..n) {
            for (st in 0 until n - len + 1) {
                val end = st + len - 1
                dp[st][end] = maxOf(dp[st][end], dp[st][end - 1], dp[st + 1][end])
            }
        }

        val rst = IntArray(queries.size)
        for ((i, query) in queries.withIndex())
            rst[i] = dp[query[0]][query[1]]
        return rst
    }
}
