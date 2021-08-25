package com.ypwang.medium

class Solution1975 {
    fun maxMatrixSum(matrix: Array<IntArray>): Long {
        var sum = 0L
        var cn = 0
        var min = Int.MAX_VALUE

        for (arr in matrix) {
            for (c in arr) {
                if (c > 0)
                    sum += c
                else {
                    sum -= c
                    cn++
                }
                min = minOf(min, Math.abs(c))
            }
        }

        if (cn % 2 == 0)
            return sum

        return sum - 2 * min
    }
}