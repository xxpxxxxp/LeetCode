package com.ypwang.hard

class Solution3826 {
    private val INF = 1_000_000_000_000_000_000L

    fun minPartitionScore(nums: IntArray, k: Int): Long {
        val n = nums.size

        val prefix = LongArray(n + 1)
        for (i in nums.indices)
            prefix[i + 1] = prefix[i] + nums[i]

        val dp = Array(n) { LongArray(k + 1) { -1L } }

        fun recursion(i: Int, k: Int): Long {
            if (i == n && k == 0)
                return 0L
            if (i == n || k == 0)
                return INF

            if (dp[i][k] == -1L) {
                var ans = INF
                for (j in i..n - k) {
                    val sum = prefix[j + 1] - prefix[i]
                    val cost = sum * (sum + 1) / 2

                    if (cost >= ans)
                        break

                    ans = minOf(ans, cost + recursion(j + 1, k - 1))
                }

                dp[i][k] = ans
            }

            return dp[i][k]
        }

        return recursion(0, k)
    }
}
