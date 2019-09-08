package com.ypwang.medium

class Solution1182 {
    fun shortestDistanceColor(colors: IntArray, queries: Array<IntArray>): List<Int> {
        val dp = Array(colors.size+2){ IntArray(3) }
        dp[0] = intArrayOf(1000000, 1000000, 1000000)
        dp[colors.size+1] = intArrayOf(1000000, 1000000, 1000000)

        for (i in colors.indices) {
            dp[i+1][0] = dp[i][0] + 1
            dp[i+1][1] = dp[i][1] + 1
            dp[i+1][2] = dp[i][2] + 1
            dp[i+1][colors[i]-1] = 0
        }

        for (i in colors.indices.reversed()) {
            dp[i+1][0] = minOf(dp[i+2][0] + 1, dp[i+1][0])
            dp[i+1][1] = minOf(dp[i+2][1] + 1, dp[i+1][1])
            dp[i+1][2] = minOf(dp[i+2][2] + 1, dp[i+1][2])
        }

        val rst = mutableListOf<Int>()
        for (q in queries) {
            rst.add(dp[q[0]+1][q[1]-1].let { if (it >= 1000000) -1 else it })
        }

        return rst
    }
}

fun main() {
    println(Solution1182().shortestDistanceColor(intArrayOf(1,1,2,1,3,2,2,3,3), arrayOf(
            intArrayOf(1,3), intArrayOf(2,2), intArrayOf(6,1)
    )))
}