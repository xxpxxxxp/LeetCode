package com.ypwang.hard

class Solution1510 {
    fun winnerSquareGame(n: Int): Boolean {
        val dp = BooleanArray(n+1)

        for (i in 1..n)
            dp[i] = (1..(Math.sqrt(i.toDouble()).toInt())).any { !dp[i - it * it] }

        return dp.last()
    }
}

fun main() {
    println(Solution1510().winnerSquareGame(1))
    println(Solution1510().winnerSquareGame(2))
    println(Solution1510().winnerSquareGame(4))
    println(Solution1510().winnerSquareGame(7))
    println(Solution1510().winnerSquareGame(17))
}