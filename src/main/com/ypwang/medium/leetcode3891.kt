package com.ypwang.medium

class Solution3891{
    fun minIncrease(nums: IntArray): Long {
        val n = nums.size
        var ans = 0L
        // Greedy for odd indices
        for (i in 1 until n - 1 step 2) {
            val maxi = maxOf(nums[i - 1], nums[i + 1])
            if (nums[i] > maxi)
                continue
            ans += (maxi - nums[i] + 1)
        }

        // If odd length pattern works directly
        if ((n - 3) % 2 == 0)
            return ans

        val dp = mutableMapOf<Int, Pair<Long, Long>>()

        fun solve(arr: IntArray, ind: Int): Pair<Long, Long> {
            if (ind >= arr.size - 1)
                return Pair(0L, 0L)

            dp[ind]?.let { return it }

            val valNeeded = maxOf(
                maxOf(arr[ind - 1], arr[ind + 1]) - arr[ind] + 1,
                0
            )

            val skip = solve(arr, ind + 1)

            val takeNext = solve(arr, ind + 2)
            val take = Pair(
                takeNext.first + 1,
                takeNext.second + valNeeded
            )

            val res = if (
                take.first > skip.first ||
                (take.first == skip.first && take.second < skip.second)
            )
                take
            else
                skip

            dp[ind] = res
            return res
        }

        // Otherwise use DP
        return solve(nums, 1).second
    }
}
