package com.ypwang.medium

class Solution1690 {
    fun stoneGameVII(stones: IntArray): Int {
        val preSum = IntArray(stones.size + 1)
        for ((i, s) in stones.withIndex()) {
            preSum[i+1] = preSum[i] + s
        }

        val dp = Array(stones.size){ IntArray(stones.size) }
        for (len in 1 until stones.size) {
            for (i in 0 until stones.size - len) {
                dp[i][i+len] = maxOf(
                    // take left side stone, get (i+1..i+len) points
                    preSum[i+len+1] - preSum[i+1] - dp[i+1][i+len],
                    // take right side stone, get (i..i+len-1) points
                    preSum[i+len] - preSum[i] - dp[i][i+len-1]
                )
            }
        }

        return dp[0][stones.lastIndex]
    }
}

fun main() {
    println(Solution1690().stoneGameVII(intArrayOf(5,3,1,4,2)))
    println(Solution1690().stoneGameVII(intArrayOf(7,90,5,1,100,10,10,2)))
}