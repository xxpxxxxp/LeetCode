package com.ypwang.hard

class Solution1866 {
    fun rearrangeSticks(n: Int, k: Int): Int {
        val dp = Array(n+1) { IntArray(k+1) { -1 } }

        fun helper(m: Int, j: Int): Int {
            if (m == j) return 1
            if (j == 0) return 0

            if (dp[m][j] == -1)
                dp[m][j] = ((helper(m-1, j-1) + helper(m-1, j) * (m-1L)) % 1000000007).toInt()

            return dp[m][j]
        }

        return helper(n, k)
    }
}

fun main() {
    println(Solution1866().rearrangeSticks(3, 2))
    println(Solution1866().rearrangeSticks(5, 5))
    println(Solution1866().rearrangeSticks(20, 11))
}