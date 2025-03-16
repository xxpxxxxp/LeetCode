package com.ypwang.medium

class Solution3489 {
    fun solve(q: Array<IntArray>, i: Int, target: Int, k: Int, dp: Array<IntArray>): Int {
        if (target == 0)
            // we found a valid sum equal to target so return current index of query.
            return k
        if (k >= q.size || target < 0)
            // return a larger number to invalidate this flow
            return q.size + 1
        if (dp[target][k] != -1)
            return dp[target][k]

        var res = solve(q, i, target, k + 1, dp)
        if (q[k][0] <= i && i <= q[k][1])
            res = minOf(res, solve(q, i, target - q[k][2], k + 1, dp))
        dp[target][k] = res

        return res
    }

    fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
        var ans = -1
        for (i in nums.indices) {
            val dp = Array(nums[i] + 1) { IntArray(queries.size) { -1 } }
            ans = maxOf(ans, solve(queries, i, nums[i], 0, dp))
        }
        return if (ans > queries.size) -1 else ans
    }
}
