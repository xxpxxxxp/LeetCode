package com.ypwang.medium

class Solution1006 {
    fun clumsy(N: Int): Int {
        return when (N) {
            1 -> 1
            2 -> 2
            3 -> 6
            4 -> 5
            else -> {
                var initial = N * (N-1) / (N-2) + N-3
                var cur = N - 4

                while (cur > 0) {
                    val a = cur
                    val b = if (cur > 1) cur - 1 else 1
                    val c = if (cur > 2) cur - 2 else 1
                    val d = if (cur > 3) cur - 3 else 0
                    initial -= a * b / c - d
                    cur -= 4
                }

                return initial
            }
        }
    }
}

fun main() {
    println(Solution1006().clumsy(10))
}