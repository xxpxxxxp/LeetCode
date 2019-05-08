package com.ypwang.easy

class Solution1033 {
    fun numMovesStones(a: Int, b: Int, c: Int): IntArray {
        val (x, y, z) = listOf(a, b, c).sorted()

        if (z - x == 2) return intArrayOf(0, 0)

        val high = z - x - 2
        if (y - x < 3 || z - y < 3) return intArrayOf(1, high)
        return intArrayOf(2, high)
    }
}

fun main() {
    println(Solution1033().numMovesStones(1, 2, 5))
}