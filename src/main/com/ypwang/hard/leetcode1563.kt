package com.ypwang.hard

class Solution1563 {
    fun stoneGameV(stoneValue: IntArray): Int {
        val dp = Array(stoneValue.size) { IntArray(stoneValue.size) }
        val sumArr = IntArray(stoneValue.size+1)
        var sum = 0
        for ((i, c) in stoneValue.withIndex()) {
            sum += c
            sumArr[i+1] = sum
        }

        for (len in 1 until stoneValue.size) {
            for (i in 0 until (stoneValue.size - len)) {
                val totalSum = sumArr[i+len+1] - sumArr[i]
                for (j in i+1..i+len) {
                    val leftSum = sumArr[j] - sumArr[i]
                    when {
                        2 * leftSum > totalSum -> dp[i][i+len] = maxOf(dp[i][i+len], totalSum - leftSum + dp[j][i+len])
                        2 * leftSum == totalSum -> dp[i][i+len] = maxOf(dp[i][i+len], leftSum + dp[i][j-1], leftSum + dp[j][i+len])
                        else -> dp[i][i+len] = maxOf(dp[i][i+len], leftSum + dp[i][j-1])
                    }
                }
            }
        }

        return dp[0][stoneValue.lastIndex]
    }
}

fun main() {
    println(Solution1563().stoneGameV(intArrayOf(6,2,3,4,5,5)))
    println(Solution1563().stoneGameV(intArrayOf(7,7,7,7,7,7,7)))
    println(Solution1563().stoneGameV(intArrayOf(4)))
}