package com.ypwang.medium

class Solution1986 {
    fun minSessions(tasks: IntArray, sessionTime: Int): Int {
        val dp = Array(1 shl tasks.size) { IntArray(sessionTime+1) { -1 } }

        fun helper(mask: Int, cur: Int): Int {
            if (mask == 0)
                return 0

            if (dp[mask][cur] == -1) {
                var rst = Int.MAX_VALUE
                for ((i, v) in tasks.withIndex()) {
                    if (mask and (1 shl i) > 0) {
                        // start a new session
                        rst = minOf(rst, 1 + helper(mask xor (1 shl i), sessionTime - v))
                        if (cur >= v)
                            rst = minOf(rst, helper(mask xor (1 shl i), cur - v))
                    }
                }
                dp[mask][cur] = rst
            }

            return dp[mask][cur]
        }

        return helper((1 shl tasks.size) - 1, 0)
    }
}

fun main() {
    println(Solution1986().minSessions(intArrayOf(1,2,3), 3))
    println(Solution1986().minSessions(intArrayOf(3,1,3,1,1), 8))
    println(Solution1986().minSessions(intArrayOf(1,2,3,4,5), 15))
}