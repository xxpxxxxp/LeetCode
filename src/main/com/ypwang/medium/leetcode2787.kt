package com.ypwang.medium

class Solution2787 {
    fun numberOfWays(n: Int, x: Int): Int {
        val elements = mutableListOf<Int>()
        for (i in 1 .. n) {
            val p = Math.pow(i.toDouble(), x.toDouble()).toInt()
            if (p > n)
                break

            elements.add(p)
        }

        // 0..n
        val dp = LongArray(n+1)
        dp[0] = 1L

        for (p in elements) {
            for (i in n downTo 1) {
                if (i >= p && dp[i-p] > 0)
                    dp[i] += dp[i-p]
            }
        }

        return (dp.last() % 1000000007).toInt()
    }
}

fun main() {
    println(Solution2787().numberOfWays(10, 2))
    println(Solution2787().numberOfWays(4, 1))
}