package com.ypwang.hard

class Solution2719 {
    fun count(num1: String, num2: String, min_sum: Int, max_sum: Int): Int {
        val dp1 = Array(23) { Array(401) { IntArray(2) } }
        val dp2 = Array(23) { Array(401) { IntArray(2) } }
        val mod = 1000000007

        fun dfs(i: Int, sum: Int, cap: String, lim: Int, equal: Boolean, dp: Array<Array<IntArray>>): Int {
            if (i == cap.length || sum > max_sum)
                return if (sum in min_sum..max_sum && (equal || lim == 0)) 1 else 0

            if (dp[i][sum][lim] == 0) {
                dp[i][sum][lim] = 1
                val up = if (lim > 0) cap[i] - '0' else 9
                for (n in 0..up) {
                    dp[i][sum][lim] = (dp[i][sum][lim] +
                            dfs(i+1, sum + n, cap, if (lim > 0 && (n == cap[i] - '0')) 1 else 0, equal, dp)
                            ) % mod
                }
            }
            return dp[i][sum][lim] - 1
        }

        return dfs(0, 0, num2, 1, true, dp2) - dfs(0, 0, num1, 0, false, dp1)
    }
}