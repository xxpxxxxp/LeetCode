package com.ypwang.medium

class Solution1895 {
    fun largestMagicSquare(grid: Array<IntArray>): Int {
        val rowSum = grid.map { it.copyOf() }.toTypedArray()
        val colSum = grid.map { it.copyOf() }.toTypedArray()
        val x1Sum = grid.map { it.copyOf() }.toTypedArray()
        val x2Sum = grid.map { it.copyOf() }.toTypedArray()

        for (i in grid.indices) {
             for (j in grid[0].indices) {
                 if (i > 0)
                     rowSum[i][j] += rowSum[i-1][j]

                 if (j > 0)
                     colSum[i][j] += colSum[i][j-1]

                 if (i > 0 && j > 0)
                     x1Sum[i][j] += x1Sum[i-1][j-1]

                 if (i > 0 && j < grid[0].lastIndex)
                     x2Sum[i][j] += x2Sum[i-1][j+1]
             }
        }

        var max = 1
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                for (k in 1 until minOf(grid.size, grid[0].size)) {
                    if (i+k == grid.size || j+k == grid[0].size)
                        break

                    val sum1 = x1Sum[i+k][j+k] - (if (i == 0 || j == 0) 0 else x1Sum[i-1][j-1])
                    val sum2 = x2Sum[i+k][j] - (if (i == 0 || j+k+1 == grid[0].size) 0 else x2Sum[i-1][j+k+1])
                    if (sum1 != sum2)
                        continue

                    var match = true
                    for (l in 0 until k) {
                        val row = rowSum[i+k][j+l] - (if (i == 0) 0 else rowSum[i-1][j+l])
                        val col = colSum[i+l][j+k] - (if (j == 0) 0 else colSum[i+l][j-1])

                        if (row != sum1 || col != sum1) {
                            match = false
                            break
                        }
                    }

                    if (match)
                        max = maxOf(max, k+1)
                }
            }
        }

        return max
    }
}

fun main() {
    println(Solution1895().largestMagicSquare(arrayOf(
        intArrayOf(7,1,4,5,6),intArrayOf(2,5,1,6,4),intArrayOf(1,5,4,3,2),intArrayOf(1,2,7,3,4)
    )))
    println(Solution1895().largestMagicSquare(arrayOf(
        intArrayOf(5,1,3,1),intArrayOf(9,3,3,1),intArrayOf(1,3,3,8)
    )))
}