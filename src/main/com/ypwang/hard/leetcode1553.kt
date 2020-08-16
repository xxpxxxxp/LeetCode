package com.ypwang.hard

class Solution1553 {
    fun minDays(n: Int): Int {
        val dp = mutableMapOf(0 to 0, 1 to 1)

        fun get(i: Int): Int {
            if (i !in dp)
                dp[i] = 1 + minOf(i%2 + get(i/2), i%3 + get(i/3))
            return dp[i]!!
        }

        return get(n)
    }
}

fun main() {
    println(Solution1553().minDays(10))
}