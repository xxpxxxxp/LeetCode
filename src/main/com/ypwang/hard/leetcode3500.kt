package com.ypwang.hard

class Solution3500 {
    fun minimumCost(nums: IntArray, cost: IntArray, k: Int): Long {
        val n = nums.size
        val prefixNums = LongArray(n)
        prefixNums[0] = nums[0].toLong()
        for (i in 1 until n)
            prefixNums[i] = prefixNums[i - 1] + nums[i]

        val prefixCosts = LongArray(n)
        prefixCosts[0] = cost[0].toLong()
        for (i in 1 until n)
            prefixCosts[i] = prefixCosts[i - 1] + cost[i]

        val dp = arrayOfNulls<LongArray>(n).map { arrayOfNulls<Long>(n) }.toTypedArray()

        fun solve(start: Int, end: Int): Long {
            val n = prefixNums.size
            if (end == n)
                return if (start == n) 0 else Long.MAX_VALUE

            dp[start][end]?.let { return it }

            val currentNumsSum = if (start == 0)
                prefixNums[end]
            else
                prefixNums[end] - prefixNums[start - 1]

            val currentCostSum = if (start == 0)
                prefixCosts[n - 1]
            else
                prefixCosts[n - 1] - prefixCosts[start - 1]

            return minOf((currentNumsSum + k) * currentCostSum + solve(end + 1, end + 1), solve(start, end + 1)).also { dp[start][end] = it }
        }

        return solve(0, 0)
    }
}
