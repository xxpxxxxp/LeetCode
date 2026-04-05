package com.ypwang.hard

class Solution3892 {
    fun minOperations(nums: IntArray, k: Int): Int {
        val INF = 100000000
        val n = nums.size

        if (k > n / 2)
            return -1

        fun cost(ind: Int): Int {
            val l = (ind - 1 + n) % n
            val r = (ind + 1) % n
            return maxOf(0, maxOf(nums[l], nums[r]) - nums[ind] + 1)
        }

        fun solve(ind: Int, remaining: Int, end: Int, dp: Array<IntArray>): Int {
            if (remaining == 0)
                return 0

            if (ind > end)
                return INF

            if (dp[ind][remaining] != -1)
                return dp[ind][remaining]

            dp[ind][remaining] = minOf(solve(ind + 1, remaining, end, dp), cost(ind) + solve(ind + 2, remaining - 1, end, dp))
            return dp[ind][remaining]
        }

        // Count existing peaks
        var cnt = 0
        for (i in 0 until n) {
            val l = (i - 1 + n) % n
            val r = (i + 1) % n
            if (nums[i] > nums[l] && nums[i] > nums[r])
                cnt++
        }

        if (cnt >= k)
            return 0

        // Case 1: [1 → n-1]
        // Case 2: [0 → n-2]
        val ans = minOf(
            solve(1, k, n - 1, Array(n + 2) { IntArray(k + 1) { -1 } }),
            solve(0, k, n - 2, Array(n + 2) { IntArray(k + 1) { -1 } })
        )
        return if (ans >= INF) -1 else ans
    }
}
