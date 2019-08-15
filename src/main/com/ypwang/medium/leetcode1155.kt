package com.ypwang.medium

class Solution1155 {
    fun numRollsToTarget(d: Int, f: Int, target: Int): Int {
        val dp = IntArray(d * target)
        for (i in 0 until minOf(f, target))
            dp[i] = 1

        for (j in 1 until d) {
            for (i in 0 until target) {
                var s = 0L
                if (i > 0) s += dp[j*target+i-1]
                if (i > f) s -= dp[(j-1)*target+i-f-1]
                if (i > 0) s += dp[(j-1)*target+i-1]
                dp[j*target+i] = ((s + 1000000007) % 1000000007).toInt()
            }
        }

        return dp.last()
    }
}

fun main() {
    println(Solution1155().numRollsToTarget(1,6,3))
    println(Solution1155().numRollsToTarget(2,6,7))
    println(Solution1155().numRollsToTarget(2,5,10))
    println(Solution1155().numRollsToTarget(1,2,3))
    println(Solution1155().numRollsToTarget(30,30,500))
    println(Solution1155().numRollsToTarget(20,19,233))
}