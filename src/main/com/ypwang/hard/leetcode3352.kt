package com.ypwang.hard

class Solution3352 {
    private val mod = 1000000007

    fun countKReducibleNumbers(s: String, k: Int): Int {
        val cnt = IntArray(801)
        val dp = Array(801) { Array(2) { IntArray(801) { -1 } } }

        for (i in 2..800) {
            val setBits = Integer.bitCount(i)
            cnt[i] = 1 + cnt[setBits]
        }

        fun solve(i: Int, tight: Boolean, setBits: Int): Int {
            if (i == s.length)
                return if (tight || setBits == 0) 0 else if (cnt[setBits] < k) 1 else 0
            if (dp[i][if (tight) 1 else 0][setBits] != -1)
                return dp[i][if (tight) 1 else 0][setBits]

            if (tight) {
                if (s[i] == '0')
                    return solve(i + 1, true, setBits)

                val res = (solve(i + 1, true, setBits + 1) + solve(i + 1, false, setBits)) % mod
                dp[i][1][setBits] = res
                return res
            }

            val res = (solve(i + 1, false, setBits + 1) + solve(i + 1, false, setBits)) % mod
            dp[i][0][setBits] = res
            return res
        }

        return solve(0, true, 0)
    }
}
