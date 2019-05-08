package com.ypwang.easy

class Solution1025 {
    fun divisorGame(N: Int): Boolean {
        // A is playing
        val aMayWin = mutableMapOf(1 to false)
        // B is playing
        val aMustWin = mutableMapOf(1 to true)

        // return for n, A could win or not
        fun helper(n: Int, isAMove: Boolean): Boolean {
            if (isAMove && n in aMayWin) return aMayWin[n]!!
            if (!isAMove && n in aMustWin) return aMustWin[n]!!

            val factors = (1..Math.sqrt(n.toDouble()).toInt()).filter { n % it == 0 }
            return if (isAMove) {
                aMayWin[n] = factors.any { helper(n - it, false) }
                aMayWin[n]!!
            } else {
                aMustWin[n] = factors.all { helper(n - it, true) }
                aMustWin[n]!!
            }
        }

        return helper(N, true)
    }
}

fun main() {
    println(Solution1025().divisorGame(5))
}