package com.ypwang.medium

class Solution2572 {
    fun squareFreeSubsets(nums: IntArray): Int {
        val dp = Array(1001) { IntArray(1024) {-1} }
        val mod = 1000000007
        val f = intArrayOf(-1, 0, 1, 2, -1, 4, 3, 8, -1, -1, 5, 16, -1, 32, 9, 6,
            -1, 64, -1, 128, -1, 10, 17, 256, -1, -1, 33, -1, -1, 512, 7)

        fun dfs(i: Int, mask: Int): Int {
            if (i >= nums.size)
                return 0
            if (dp[i][mask] < 0) {
                dp[i][mask] = dfs(i + 1, mask)
                if (f[nums[i]] != -1 && mask and f[nums[i]] == 0)
                    dp[i][mask] = (dp[i][mask] + 1 + dfs(i+1, mask or f[nums[i]])) % mod
            }
            return dp[i][mask]
        }

        return dfs(0, 0)
    }
}