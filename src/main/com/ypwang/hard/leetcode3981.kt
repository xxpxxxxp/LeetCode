package com.ypwang.hard

class Solution3981 {
    var mod = 1000000007

    fun interleaveCharacters(word1: String, word2: String, target: String): Int {
        val dp = Array(101) { Array(101) { IntArray(101) { -1 } } }

        fun dfs(i: Int, j: Int, k: Int): Int {
            if (k == target.length)
                return if (i > 0 && j > 0) 1 else 0
            if (i == word1.length && j == word2.length)
                return 0
            if (dp[i][j][k] != -1)
                return dp[i][j][k]

            var ans = 0L
            for (x in i until word1.length)
                if (word1[x] == target[k])
                    ans = (ans + dfs(x + 1, j, k + 1)) % mod

            for (x in j until word2.length)
                if (word2[x] == target[k])
                    ans = (ans + dfs(i, x + 1, k + 1)) % mod

            return ans.toInt().also { dp[i][j][k] = it }
        }

        return dfs(0, 0, 0)
    }
}
