package com.ypwang.easy

class Solution1380 {
    fun luckyNumbers (matrix: Array<IntArray>): List<Int> {
        val minRow = IntArray(matrix.size)
        val maxRow = IntArray(matrix[0].size) { Int.MIN_VALUE }

        for ((i, r) in matrix.withIndex()) {
            var min = Int.MAX_VALUE
            for ((j, c) in r.withIndex()) {
                min = minOf(min, c)
                maxRow[j] = maxOf(maxRow[j], c)
            }
            minRow[i] = min
        }

        return minRow.intersect(maxRow.toSet()).toList()
    }
}