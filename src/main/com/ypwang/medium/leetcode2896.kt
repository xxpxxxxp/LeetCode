package com.ypwang.medium

class Solution2896 {
    fun minOperations(s1: String, s2: String, x: Int): Int {
        val diff = s1.zip(s2).withIndex().filter { it.value.first != it.value.second }.map { it.index }.toIntArray()
        val dp = Array(501) { IntArray(501) { -1 } }

        fun solve(l: Int, r: Int): Int {
            if (l >= r)
                return 0
            if (dp[l][r] == -1) {
                dp[l][r] = minOf(
                    minOf(x, diff[l+1] - diff[l]) + solve(l+2, r),
                    minOf(x, diff[r] - diff[l]) + solve(l+1, r-1),
                    minOf(x, diff[r] - diff[r-1]) + solve(l, r-2)
                )
            }

            return dp[l][r]
        }

        if (diff.isEmpty())
            return 0
        if (diff.size % 2 > 0)
            return -1
        return solve(0, diff.lastIndex)
    }
}