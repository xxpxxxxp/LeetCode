package com.ypwang.medium

class Solution799 {
    fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
        val glass = DoubleArray(query_row + 1){0.0}
        glass[0] = poured.toDouble()

        for (index in 0 until query_row) {
            var empty = true

            for (j in index downTo 0) {
                val part = (glass[j] - 1) / 2
                val real = if (part > 0) {
                    empty = false
                    part
                } else 0.0

                glass[j+1] += real
                glass[j] = real
            }

            if (empty)
                return 0.0
        }

        return if (glass[query_glass] > 1.0) 1.0 else glass[query_glass]
    }
}

fun main() {
    println(Solution799().champagneTower(10, 4, 1))
}