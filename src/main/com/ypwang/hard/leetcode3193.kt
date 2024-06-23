package com.ypwang.hard

class Solution3193 {
    fun numberOfPermutations(n: Int, requirements: Array<IntArray>): Int {
        requirements.sortBy { it[0] }

        val dp = Array(301) { IntArray(401) }
        fun dfs(i: Int, j: Int, cnt: Int): Int {
            var j = j
            if (i == 0 || i * (i + 1) / 2 < cnt)
                return if (cnt == 0) 1 else 0
            if (j >= 0 && requirements[j][0] == i) {
                if (requirements[j][1] != cnt)
                    return 0
                j--
            }

            if (dp[i][cnt] == 0) {
                dp[i][cnt] = 1
                for (k in 0..minOf(i, cnt)) {
                    dp[i][cnt] = (dp[i][cnt] + dfs(i - 1, j, cnt - k)) % 1000000007
                }
            }
            return dp[i][cnt] - 1
        }

        return dfs(n - 1, requirements.lastIndex, requirements.last()[1])
    }
}
