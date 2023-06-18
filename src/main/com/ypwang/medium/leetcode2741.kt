package com.ypwang.medium

class Solution2741 {
    fun specialPerm(nums: IntArray): Int {
        val dp = Array(nums.size) { IntArray(1 shl nums.size) { -1 } }

        fun dfs(i: Int, mask: Int): Int {
            if (mask == (1 shl nums.size) - 1)
                return 1

            if (dp[i][mask] == -1) {
                dp[i][mask] = 0
                for ((j, v) in nums.withIndex())
                    if ((mask and (1 shl j) == 0) && (mask == 0 || nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0))
                        dp[i][mask] = (dp[i][mask] + dfs(j, mask or (1 shl j))) % 1000000007
            }

            return dp[i][mask]
        }

        return dfs(0, 0)
    }
}