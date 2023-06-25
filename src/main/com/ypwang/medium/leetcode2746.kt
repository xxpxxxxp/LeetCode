package com.ypwang.medium

class Solution2746 {
    fun minimizeConcatenatedLength(words: Array<String>): Int {
        val dp = Array(1001) { Array(26) { IntArray(26) } }

        fun dfs(i: Int, l: Int, r: Int): Int {
            if (i == words.size)
                return 0

            val w = words[i]
            if (dp[i][l][r] == 0) {
                dp[i][l][r] = w.length + minOf(
                    dfs(i+1, l, w.last() - 'a') - if (w.first()-'a' == r) 1 else 0,
                    dfs(i+1, w.first() - 'a', r) - if (w.last()-'a' == l) 1 else 0
                )
            }
            return dp[i][l][r]
        }

        return words[0].length + dfs(1, words[0].first() - 'a', words[0].last() - 'a')
    }
}