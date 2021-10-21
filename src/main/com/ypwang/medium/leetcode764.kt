package com.ypwang.medium

class Solution764 {
    fun orderOfLargestPlusSign(N: Int, mines: Array<IntArray>): Int {
        val mine = mines.map { it[0] * N + it[1] }.toSet()
        val mins = IntArray(N * N){Int.MAX_VALUE}

        for (i in 0 until N) {
            var cur = 0
            for (j in 0 until N) {
                val idx = i * N + j
                if (idx in mine) cur = 0
                else cur++

                mins[idx] = minOf(mins[idx], cur)
            }

            cur = 0
            for (j in N-1 downTo 0) {
                val idx = i * N + j
                if (idx in mine) cur = 0
                else cur++

                mins[idx] = minOf(mins[idx], cur)
            }
        }

        for (j in 0 until N) {
            var cur = 0
            for (i in 0 until N) {
                val idx = i * N + j
                if (idx in mine) cur = 0
                else cur++

                mins[idx] = minOf(mins[idx], cur)
            }

            cur = 0
            for (i in N-1 downTo 0) {
                val idx = i * N + j
                if (idx in mine) cur = 0
                else cur++

                mins[idx] = minOf(mins[idx], cur)
            }
        }

        return mins.maxOrNull()!!
    }
}

fun main() {
    println(Solution764().orderOfLargestPlusSign(1, arrayOf(intArrayOf(0, 0))))
}