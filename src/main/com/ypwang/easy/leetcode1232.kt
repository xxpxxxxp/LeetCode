package com.ypwang.easy

class Solution1232 {
    private fun gcd(a: Int, b: Int): Int = if (a == 0) b else gcd(b % a, a)
    private fun normalize(a: Int, b: Int): Pair<Int, Int> {
        val g = gcd(minOf(a, b), maxOf(a, b))
        return a / g to b / g
    }

    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        val (x, y) = normalize(coordinates[1][0] - coordinates[0][0], coordinates[1][1] - coordinates[0][1])

        for (i in 1 until coordinates.size-1) {
            val (nx, ny) = normalize(coordinates[i+1][0] - coordinates[i][0], coordinates[i+1][1] - coordinates[i][1])
            if (nx != x || ny != y) return false
        }

        return true
    }
}