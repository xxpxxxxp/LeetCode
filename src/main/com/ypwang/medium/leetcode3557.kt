package com.ypwang.medium

class Solution3557 {
    fun maxSubstrings(word: String): Int {
        val last = Array(26) { mutableListOf<Int>() }

        val n = word.length
        val dp = IntArray(n + 1)
        for (i in 0..<n) {
            val c = word[i] - 'a'
            dp[i + 1] = dp[i]
            for (j in last[c])
                if (i - j + 1 >= 4)
                    dp[i + 1] = maxOf(dp[i + 1], dp[j] + 1)

            last[c].add(i)
            if (last[c].size > 4)
                last[c].removeFirst()
        }
        return dp[n]
    }
}
