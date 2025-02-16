package com.ypwang.medium

class Solution3453 {
    private fun helper(line: Double, squares: Array<IntArray>): Double {
        var aAbove = 0.0
        var aBelow = 0.0
        for ((_, y, l) in squares) {
            val total = l.toDouble() * l

            when {
                line <= y -> aAbove += total
                line >= y + l -> aBelow += total
                else -> {
                    // The line intersects the square.
                    val aboveHeight = (y + l) - line
                    val belowHeight = line - y
                    aAbove += l * aboveHeight
                    aBelow += l * belowHeight
                }
            }
        }
        return aAbove - aBelow
    }

    fun separateSquares(squares: Array<IntArray>): Double {
        var lo = 0.0
        var hi = 2 * 1e9

        repeat(60) {
            val mid = (lo + hi) / 2.0
            val diff = helper(mid, squares)

            if (diff > 0) lo = mid
            else hi = mid
        }

        return hi
    }
}
