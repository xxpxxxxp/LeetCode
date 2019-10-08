package com.ypwang.hard

class Solution730 {
    fun countPalindromicSubsequences(S: String): Int {
        val n = S.length

        fun leftNext(rec: IntArray): IntArray {
            val res = IntArray(n)

            return res
        }

        val rec = intArrayOf(n, n, n, n)
        val rightNext = IntArray(n)
        for (i in n - 1 downTo 0) {
            rightNext[i] = rec[S[i] - 'a']
            rec[S[i] - 'a'] = i
        }

        rec.fill(-1)
        val leftNext = IntArray(n)
        for (i in 0 until n) {
            leftNext[i] = rec[S[i] - 'a']
            rec[S[i] - 'a'] = i
        }

        val dp = Array(n) { IntArray(n) }
        for (d in 0 until n) {
            var i = 0
            var j = i + d
            while (j < n) {
                dp[i][j] = when {
                    i == j -> 1
                    S[i] != S[j] -> dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1]
                    else -> {
                        val r = rightNext[i]
                        val l = leftNext[j]
                        2 * dp[i + 1][j - 1] + when {
                            r < l -> -dp[r + 1][l - 1]
                            r == l -> 1
                            else -> 2
                        }
                    }
                }
                dp[i][j] = if (dp[i][j] < 0) dp[i][j] + 1000000007 else dp[i][j] % 1000000007
                i++
                j++
            }
        }
        return dp[0][n - 1]
    }
}