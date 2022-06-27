package com.ypwang.hard

class Solution2318 {
    fun distinctSequences(n: Int): Int {
        val memo = Array(10001) { Array(7) { IntArray(7) } }
        val mod = 1000000007
        val m = arrayOf(
            intArrayOf(1, 2, 3, 4, 5, 6),
            intArrayOf(2, 3, 4, 5, 6),
            intArrayOf(1, 3, 5),
            intArrayOf(1, 2, 4, 5),
            intArrayOf(1, 3, 5),
            intArrayOf(1, 2, 3, 4, 6),
            intArrayOf(1, 5)
        )

        fun dp(n: Int, prev: Int, pprev: Int): Int {
            if (n == 0)
                return 1
            if (memo[n][prev][pprev] != 0)
                return memo[n][prev][pprev]

            var ans = 0
            for (x in m[prev])
                if (x != pprev)
                    ans = (ans + dp(n - 1, x, prev)) % mod
            return ans.also { memo[n][prev][pprev] = it }
        }

        return dp(n, 0, 0)
    }
}