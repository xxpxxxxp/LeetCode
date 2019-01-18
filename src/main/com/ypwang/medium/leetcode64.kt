package com.ypwang.medium

class Solution64 {
    fun minPathSum(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val dp = IntArray(m * n){ 0 }

        fun calc(x: Int, y: Int): Int = x * n + y

        var sum = 0
        for (i in 0 until m) {
            sum += grid[i][0]
            dp[calc(i, 0)] = sum
        }

        sum = 0
        for (i in 0 until n) {
            sum += grid[0][i]
            dp[calc(0, i)] = sum
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                dp[calc(i, j)] = Math.min(dp[calc(i-1, j)], dp[calc(i, j-1)]) + grid[i][j]
            }
        }

        return dp[calc(m - 1, n - 1)]
    }
}

fun main(args: Array<String>) {
    println(Solution64().minPathSum(
            arrayOf(
                    intArrayOf(1,3,1), intArrayOf(1,5,1), intArrayOf(4,2,1)
            )
    ))
}