package com.ypwang.medium

class Solution221 {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty())
            return 0

        val m = matrix.size
        val n = matrix[0].size

        // (x ... len, y ... len, square ... len)
        val cache = Array(m * n){ arrayOf(0, 0, 0) }

        var max = 0
        for (i in 0 until n) {
            if (matrix[0][i] == '1') {
                cache[i][0] = 1
                cache[i][1] = 1
                cache[i][2] = 1
                max = 1
            }
        }

        for (i in 1 until m) {
            if (matrix[i][0] == '1') {
                cache[i * n][0] = 1
                cache[i * n][1] = 1
                cache[i * n][2] = 1
                max = 1
            }
        }

        for (i in 1 until n) {
            for (j in 1 until m) {
                if (matrix[j][i] == '1') {
                    val x = 1 + cache[j * n + i - 1][0]
                    cache[j * n + i][0] = x
                    val y = 1 + cache[(j - 1) * n + i][1]
                    cache[j * n + i][1] = y
                    val z = minOf(x, y, 1 + cache[(j - 1) * n + i - 1][2])
                    cache[j * n + i][2] = z
                    if (z * z > max) {
                        max = z * z
                    }
                }
            }
        }

        return max
    }
}

fun main() {
    println(Solution221().maximalSquare(
            arrayOf(
                    "10100".toCharArray(),
                    "10111".toCharArray(),
                    "11111".toCharArray(),
                    "10010".toCharArray()
            )
    ))
}