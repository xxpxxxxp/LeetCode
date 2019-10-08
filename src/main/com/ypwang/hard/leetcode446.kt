package com.ypwang.hard

class Solution446 {
    fun numberOfArithmeticSlices(A: IntArray): Int {
        val dp = Array(A.size){ mutableMapOf<Int, Int>() }

        var rst = 0L
        for (i in A.indices) {
            for (j in 0 until i) {
                val diff = A[i].toLong() - A[j].toLong()
                if (diff < Int.MIN_VALUE || diff > Int.MAX_VALUE) continue

                val idiff = diff.toInt()
                val pre = dp[j].getOrDefault(idiff, 0)
                val cur = dp[i].getOrDefault(idiff, 0)
                dp[i][idiff] = cur + pre + 1
                rst += pre
            }
        }

        return rst.toInt()
    }
}

fun main() {
    println(Solution446().numberOfArithmeticSlices(intArrayOf(2,4,6,8,10)))
}