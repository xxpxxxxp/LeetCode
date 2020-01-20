package com.ypwang.hard

class Solution1000 {
    fun mergeStones(stones: IntArray, K: Int): Int {
        if ((stones.size - 1) % (K - 1) != 0) return -1

        val partialSum = IntArray(stones.size+1)
        for (i in stones.indices)
            partialSum[i+1] = partialSum[i] + stones[i]
        val dp = Array(stones.size){ IntArray(stones.size) }

        for (m in K..stones.size) {
            for (i in 0..(stones.size - m)) {
                val j = i + m - 1
                dp[i][j] = Int.MAX_VALUE
                for (mid in i until j step K-1)
                    dp[i][j] = minOf(dp[i][j], dp[i][mid] + dp[mid+1][j])
                if ((j-i) % (K-1) == 0) dp[i][j] += partialSum[j+1] - partialSum[i]
            }
        }

        return dp[0][stones.lastIndex]
    }
}

fun main() {
    println(Solution1000().mergeStones(intArrayOf(3,2,4,1), 2))
}