package com.ypwang.medium

class Solution688 {
    fun knightProbability(N: Int, K: Int, r: Int, c: Int): Double {
        val move = listOf(1 to 2, 1 to -2, -1 to 2, -1 to -2, 2 to 1, 2 to -1, -2 to 1, -2 to -1)
        val find = mutableMapOf<Pair<Pair<Int, Int>, Int>, Double>()

        fun helper(e: Pair<Pair<Int, Int>, Int>): Double {
            if (e.first.first < 0 || e.first.first >= N || e.first.second < 0 || e.first.second >= N)
                return 0.0

            if (e.second == K)
                return 1.0

            if (e in find)
                return find[e]!!

            val p = move.map { Pair(e.first.first + it.first, e.first.second + it.second) to e.second + 1 }.sumByDouble { helper(it) } / 8.0
            find[e] = p
            return p
        }

        return helper(Pair(Pair(r, c), 0))
    }
}

fun main() {
    println(Solution688().knightProbability(3, 2, 0, 0))
}