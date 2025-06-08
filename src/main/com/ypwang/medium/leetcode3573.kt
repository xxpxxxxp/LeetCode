package com.ypwang.medium

class Solution3573 {
    fun maximumProfit(prices: IntArray, k: Int): Long {
        val res = LongArray(k + 1)
        val bought = LongArray(k) { -1000000000 }
        val sold = LongArray(k)
        for (a in prices) {
            for (j in k downTo 1) {
                res[j] = maxOf(res[j], bought[j - 1] + a, sold[j - 1] - a)
                bought[j - 1] = maxOf(bought[j - 1], res[j - 1] - a)
                sold[j - 1] = maxOf(sold[j - 1], res[j - 1] + a)
            }
        }

        return res.max()
    }
}
