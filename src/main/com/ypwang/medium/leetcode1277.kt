package com.ypwang.medium

class Solution1277 {
    fun countSquares(matrix: Array<IntArray>): Int {
        var sum = 0
        for ((i, row) in matrix.withIndex()) {
            for ((j, c) in row.withIndex()) {
                if (c == 1) {
                    var horizon = 1
                    var vertical = 1
                    var diagnol = 1

                    if (j > 0) {
                        horizon += row[j-1] shr 19
                    }

                    if (i > 0) {
                        vertical += (matrix[i-1][j] shr 10) and 0x1ff
                    }

                    if (i > 0 && j > 0) {
                        diagnol = minOf(1 + (matrix[i-1][j-1] shr 1) and 0xff, horizon, vertical)
                    }
                    sum += diagnol

                    matrix[i][j] = (horizon shl 19) or (vertical shl 10) or (diagnol shl 1) or 1
                }
            }
        }

        return sum
    }
}

fun main() {
    println(Solution1277().countSquares(arrayOf(intArrayOf(0,1,1,1), intArrayOf(1,1,1,1), intArrayOf(0,1,1,1))))
}