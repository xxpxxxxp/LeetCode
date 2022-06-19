package com.ypwang.hard

class Solution2312 {
    fun sellingWood(m: Int, n: Int, prices: Array<IntArray>): Long {
        val dp = Array(m + 1) { LongArray(n + 1) }
        for (p in prices)
            dp[p[0]][p[1]] = p[2].toLong()
        for (w in 1..m) {
            for (h in 1..n) {
                for (a in 1..w / 2)
                    dp[w][h] = maxOf(dp[w][h], dp[a][h] + dp[w - a][h])
                for (a in 1..h / 2)
                    dp[w][h] = maxOf(dp[w][h], dp[w][a] + dp[w][h - a])
            }
        }
        return dp[m][n]
    }
}

fun main() {
    println(Solution2312().sellingWood(3, 5, arrayOf(
        intArrayOf(1,4,2),intArrayOf(2,2,7),intArrayOf(2,1,3)
    )))
    println(Solution2312().sellingWood(4, 6, arrayOf(
        intArrayOf(3,2,10),intArrayOf(1,4,2),intArrayOf(4,1,3)
    )))
    println(Solution2312().sellingWood(9, 7, arrayOf(
        intArrayOf(4,3,2),intArrayOf(5,3,16),intArrayOf(4,4,18),intArrayOf(8,7,6)
    )))
}