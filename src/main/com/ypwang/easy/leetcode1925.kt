package com.ypwang.easy

class Solution1925 {
    fun countTriples(n: Int): Int {
        val squares = (1..n).map { it * it }.toIntArray()
        val set = squares.toSet()

        var c = 0
        for (i in squares.indices) {
            for (j in i until squares.size) {
                if (squares[i] + squares[j] in set) {
                    c += if (i == j) 1 else 2
                }
            }
        }

        return c
    }
}