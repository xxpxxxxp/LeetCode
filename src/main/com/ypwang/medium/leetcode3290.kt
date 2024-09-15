package com.ypwang.medium

class Solution3290 {
    fun maxScore(a: IntArray, b: IntArray): Long {
        val dp = LongArray(4) { -100000 }
        for (i in b) {
            for (j in 3 downTo 0) {
                var t = a[j].toLong() * i
                if (j > 0)
                    t += dp[j-1]
                dp[j] = maxOf(dp[j], t)
            }
        }

        return dp.last()
    }
}

fun main() {
    println(Solution3290().maxScore(
        intArrayOf(3,2,5,6),
        intArrayOf(2,-6,4,-5,-3,2,-7)
    ))
}