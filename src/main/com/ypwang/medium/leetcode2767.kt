package com.ypwang.medium

class Solution2767 {
    fun minimumBeautifulSubstrings(s: String): Int {
        val dp = IntArray(s.length + 1) { 100000 }
        dp[0] = 0
        for ((i, c) in s.withIndex())  {
            if  (c == '1') {
                var cur = 0
                for (j in i until s.length) {
                    cur = cur * 2 + (s[j] - '0')
                    if (15625 % cur == 0)
                        dp[j+1] = minOf(dp[j+1], dp[i]+1)
                }
            }
        }
        return if (dp.last() >= 100000) -1 else dp.last()
    }
}