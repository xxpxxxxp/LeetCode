package com.ypwang.medium

class Solution322 {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val cache = Array(amount + 1){0}

        val cm = coins.minOrNull()!!
        for (i in 1 until minOf(cm, cache.size)) {
            cache[i] = -1
        }

        for (i in cm .. amount) {
            val q = coins.filter { i - it >= 0 }.map {
                val p = cache[i - it]
                if (p < 0) p else p + 1
            }.filter { it != -1 }

            cache[i] = if (q.isEmpty()) -1 else q.minOrNull()!!
        }

        return cache.last()
    }
}

fun main() {
    println(Solution322().coinChange(intArrayOf(2), 3))
}