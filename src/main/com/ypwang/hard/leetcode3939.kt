package com.ypwang.hard

class Solution3939 {
    private val mod = 1_000_000_007L

    fun countValidSubsets(parent: IntArray, nums: IntArray, k: Int): Int {
        val n = parent.size

        val adj = Array(n) { mutableListOf<Int>() }
        for (i in 0 until n)
            if (parent[i] != -1)
                adj[parent[i]].add(i)

        val dp = Array(n) { Array(2) { LongArray(k) } }

        fun dfs(u: Int) {
            dp[u][0][0] = 1L                  // u not taken
            dp[u][1][nums[u] % k] = 1L        // u taken

            for (v in adj[u]) {
                dfs(v)

                val dp2 = Array(2) { LongArray(k) }

                // u not taken
                for (a in 0 until k) {
                    for (b in 0 until k) {
                        // 2 choices for child
                        val x = (dp[v][0][b] + dp[v][1][b]) % mod
                        dp2[0][(a + b) % k] =
                            (dp2[0][(a + b) % k] + (dp[u][0][a] * x) % mod) % mod
                    }
                }

                // u taken
                for (a in 0 until k) {
                    for (b in 0 until k) {
                        // only 1 choice for child
                        dp2[1][(a + b) % k] =
                            (dp2[1][(a + b) % k] +
                                    (dp[u][1][a] * dp[v][0][b]) % mod) % mod
                    }
                }

                dp[u] = dp2
            }
        }

        dfs(0)

        // subtract 1 to exclude empty set
        val ans = (dp[0][0][0] + dp[0][1][0] - 1 + mod) % mod
        return ans.toInt()
    }
}
