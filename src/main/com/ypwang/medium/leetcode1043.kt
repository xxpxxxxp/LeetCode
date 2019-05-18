package com.ypwang.medium

class Solution1043 {
    fun maxSumAfterPartitioning(A: IntArray, K: Int): Int {
        if (A.isEmpty()) return 0

        val dp = IntArray(A.size + 1)
        for (i in 1 until A.size+1) {
            var max = Int.MIN_VALUE
            for (k in 1..K) {
                val idx = i - k
                if (idx >= 0) {
                    max = maxOf(max, A[idx])
                    dp[i] = maxOf(dp[i], dp[idx] + max * k)
                }
            }
        }

        return dp.last()
    }
}

fun main() {
    println(Solution1043().maxSumAfterPartitioning(intArrayOf(1,15,7,9,2,5,10), 3))
}