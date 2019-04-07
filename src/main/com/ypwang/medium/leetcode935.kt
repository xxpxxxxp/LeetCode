package com.ypwang.medium

class Solution935 {
    fun knightDialer(N: Int): Int {
        val map = mapOf(
                1 to listOf(6, 8),
                2 to listOf(7, 9),
                3 to listOf(4, 8),
                4 to listOf(0, 3, 9),
                5 to listOf(),
                6 to listOf(0, 1, 7),
                7 to listOf(2, 6),
                8 to listOf(1, 3),
                9 to listOf(2, 4),
                0 to listOf(4, 6)
        )

        val cache = IntArray(10 * N){1}

        for (n in 1 until N) {
            for (i in 0..9) {
                cache[n*10+i] = if (i == 5) 0 else map.getValue(i).map { cache[(n-1)*10+it] }.reduceRight { a, b -> (a + b) % 1000000007 }
            }
        }

        return (0..9).map { cache[(N-1)*10+it] }.reduceRight { a, b -> (a + b) % 1000000007 }
    }
}

fun main() {
    println(Solution935().knightDialer(161))
}