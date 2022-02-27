package com.ypwang.hard

class Solution2188 {
    fun minimumFinishTime(tires: Array<IntArray>, changeTime: Int, numLaps: Int): Int {
        val straight = IntArray(19) { Int.MAX_VALUE }
        for ((f, r) in tires) {
            var total = 0
            var cur = f
            for (i in 1 until 19) {
                total += cur
                cur *= r
                if (total > 2e5)
                    break

                straight[i] = minOf(straight[i], total)
            }
        }

        val dp = IntArray(numLaps + 1)
        for (i in 1..numLaps) {
            dp[i] = if (i < 19) straight[i] else Int.MAX_VALUE
            for (j in 1 until i/2 + 1) {
                dp[i] = minOf(dp[i], dp[j] + changeTime + dp[i-j])
            }
        }

        return dp.last()
    }
}

fun main() {
    println(Solution2188().minimumFinishTime(arrayOf(
        intArrayOf(2,3), intArrayOf(3,4)
    ), 5, 4))
}