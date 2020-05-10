package com.ypwang.hard

class Solution1444 {
    fun ways(pizza: Array<String>, k: Int): Int {
        val m = pizza.size
        val n = pizza[0].length

        val dp = Array(k){ Array(m){ IntArray(n){-1} } }
        val preSum = Array(m+1){ IntArray(n+1) }

        for (i in m-1 downTo 0) {
            for (j in n-1 downTo 0) {
                preSum[i][j] = preSum[i][j+1] + preSum[i+1][j] - preSum[i+1][j+1]
                if (pizza[i][j] == 'A')
                    preSum[i][j]++
            }
        }

        val mod = 1000000007

        fun dfs(i: Int, j: Int, left: Int): Int {
            if (preSum[i][j] == 0) return 0
            if (left == 0) return 1
            if (dp[left][i][j] < 0) {
                var rst = 0
                for (ni in i+1 until m) {
                    if (preSum[i][j] - preSum[ni][j] > 0)
                        rst = (rst + dfs(ni, j, left-1)) % mod
                }

                for (nj in j+1 until n) {
                    if (preSum[i][j] - preSum[i][nj] > 0)
                        rst = (rst + dfs(i, nj, left-1)) % mod
                }

                dp[left][i][j] = rst
            }

            return dp[left][i][j]
        }

        return dfs(0, 0, k-1)
    }
}