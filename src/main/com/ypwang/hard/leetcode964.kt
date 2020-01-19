package com.ypwang.hard

class Solution964 {
    fun leastOpsExpressTarget(x: Int, target: Int): Int {
        val cache = mutableMapOf<String, Int>()

        fun cost(i: Int): Int = if (i > 0) i else 2
        fun dp(i: Int, t: Int): Int {
            val code = "$i#$t"
            if (code in cache) return cache[code]!!

            val ans = when (t) {
                0 -> 0
                1 -> cost(i)
                else -> {
                    if (i >= 39) target + 1
                    else {
                        val n = t / x
                        val r = t % x
                        minOf(r * cost(i) + dp(i+1, n), (x-r) * cost(i) + dp(i+1, n+1))
                    }
                }
            }
            cache[code] = ans
            return ans
        }

        return dp(0, target) - 1
    }
}