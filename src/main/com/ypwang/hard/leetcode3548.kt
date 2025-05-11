package com.ypwang.hard

class Solution3548 {
    fun canPartitionGrid(grid: Array<IntArray>): Boolean {
        val n = grid.size
        val m = grid[0].size

        val prefixRowWise = LongArray(n)
        val prefixColWise = LongArray(m)

        val MAXV = 100000
        val minRow = arrayOfNulls<Int>(MAXV + 1)
        val maxRow = arrayOfNulls<Int>(MAXV + 1)
        val minCol = arrayOfNulls<Int>(MAXV + 1)
        val maxCol = arrayOfNulls<Int>(MAXV + 1)

        for (i in 0..<n) {
            for (j in 0..<m) {
                val v = grid[i][j]
                prefixRowWise[i] += v
                prefixColWise[j] += v

                if (minRow[v] == null) {
                    maxRow[v] = i
                    minRow[v] = maxRow[v]
                    maxCol[v] = j
                    minCol[v] = maxCol[v]
                } else {
                    if (i < minRow[v]!!) minRow[v] = i
                    if (i > maxRow[v]!!) maxRow[v] = i
                    if (j < minCol[v]!!) minCol[v] = j
                    if (j > maxCol[v]!!) maxCol[v] = j
                }
            }
        }

        val totalRowSum = prefixRowWise.sum()
        val totalColSum = totalRowSum

        var currentRowUpperSum = 0L
        for (i in 0 until n - 1) {
            currentRowUpperSum += prefixRowWise[i]
            val lowerSegmentSum = totalRowSum - currentRowUpperSum
            if (currentRowUpperSum == lowerSegmentSum)
                return true

            if (currentRowUpperSum > lowerSegmentSum) {
                val diff = currentRowUpperSum - lowerSegmentSum
                if (diff <= MAXV && minRow[diff.toInt()] != null) {
                    if (i == 0 || m == 1) {
                        if (diff == grid[0][0].toLong() || diff == grid[0][m - 1].toLong())
                            return true
                    } else if (minRow[diff.toInt()]!! <= i)
                        return true
                }
            } else {
                val diff = lowerSegmentSum - currentRowUpperSum
                if (diff <= MAXV && maxRow[diff.toInt()] != null) {
                    if (i == n - 2 || m == 1) {
                        if (diff == grid[i + 1][0].toLong() || diff == grid[i + 1][m - 1].toLong())
                            return true
                    } else if (maxRow[diff.toInt()]!! > i)
                        return true
                }
            }
        }

        var currentColLeftSum = 0L
        for (j in 0 until m - 1) {
            currentColLeftSum += prefixColWise[j]
            val rightSegmentSum = totalColSum - currentColLeftSum
            if (currentColLeftSum == rightSegmentSum)
                return true

            if (currentColLeftSum > rightSegmentSum) {
                val diff = currentColLeftSum - rightSegmentSum
                if (diff <= MAXV && minCol[diff.toInt()] != null) {
                    if (j == 0 || n == 1) {
                        if (diff == grid[0][0].toLong() || diff == grid[n - 1][0].toLong())
                            return true
                    } else if (minCol[diff.toInt()]!! <= j)
                        return true
                }
            } else {
                val diff = rightSegmentSum - currentColLeftSum
                if (diff <= MAXV && maxCol[diff.toInt()] != null) {
                    if (j == m - 2 || n == 1) {
                        if (diff == grid[0][j + 1].toLong() || diff == grid[n - 1][j + 1].toLong())
                            return true
                    } else if (maxCol[diff.toInt()]!! > j)
                        return true
                }
            }
        }

        return false
    }
}

fun main() {
    println(Solution3548().canPartitionGrid(arrayOf(intArrayOf(1,2,4), intArrayOf(2,3,5))))
}