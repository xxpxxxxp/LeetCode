package com.ypwang.hard

class Solution1406 {
    fun stoneGameIII(stoneValue: IntArray): String {
        val dp = IntArray(3)
        for (idx in stoneValue.lastIndex downTo 0) {
            var cur = Int.MIN_VALUE
            var sum = 0
            for (i in 0 until 3) {
                if (idx + i < stoneValue.size) {
                    sum += stoneValue[idx + i]
                    cur = maxOf(cur, sum - dp[i])
                }
            }

            dp[2] = dp[1]
            dp[1] = dp[0]
            dp[0] = cur
        }

        return if (dp[0] > 0) "Alice" else if (dp[0] == 0) "Tie" else "Bob"
    }
}

fun main() {
    println(Solution1406().stoneGameIII(intArrayOf(1,2,3,7)))
    println(Solution1406().stoneGameIII(intArrayOf(1,2,3,-9)))
    println(Solution1406().stoneGameIII(intArrayOf(1,2,3,6)))
    println(Solution1406().stoneGameIII(intArrayOf(1,2,3,-1,-2,-3,7)))
    println(Solution1406().stoneGameIII(intArrayOf(-1,-2,-3)))
}