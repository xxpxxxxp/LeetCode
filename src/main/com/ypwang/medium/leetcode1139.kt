package com.ypwang.medium

class Solution1139 {
    fun largest1BorderedSquare(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val dp = Array(m){IntArray(n)}
        for (i in 0 until m) {
            for (j in 0 until n) {
                dp[i][j] =
                    if (grid[i][j] == 0) 0
                    else {
                        var t = 0x101
                        if (i > 0) t = ((1 + (dp[i-1][j] shr 8)) shl 8) + (t and 0xff)
                        if (j > 0) t = (t and 0xff00) + (1 + (dp[i][j-1] and 0xff))
                        t
                    }
            }
        }

        var max = 0
        val dp2 = Array(m){IntArray(n)}
        for (i in m-1 downTo 0) {
            for (j in n-1 downTo 0) {
                val v =
                    if (grid[i][j] == 0) 0
                    else {
                        var t = 0x101
                        if (i+1 < m) t = ((1 + (dp2[i+1][j] shr 8)) shl 8) + (t and 0xff)
                        if (j+1 < n) t = (t and 0xff00) + (1 + (dp2[i][j+1] and 0xff))
                        t
                    }

                val limit = minOf(v and 0xff, v shr 8)
                for (p in (max+1)..limit) {
                    val x = i+p-1
                    val y = j+p-1
                    if (x >= m || y >= n) break
                    val t = minOf(dp[x][y] and 0xff, dp[x][y] shr 8, limit)
                    if (t >= p) max = p
                }

                dp2[i][j] = v
            }
        }

        return max * max
    }
}

fun main() {
    println(Solution1139().largest1BorderedSquare(arrayOf(
            intArrayOf(1,1,0,0)
    )))
}