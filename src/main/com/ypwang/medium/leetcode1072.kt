package com.ypwang.medium

class Solution1072 {
    fun maxEqualRowsAfterFlips(matrix: Array<IntArray>): Int {
        val count = mutableMapOf<String, Int>()

        for (row in matrix) {
            val a = row.joinToString("")
            val b = row.map {
                when (it) {
                    0 -> 1
                    1 -> 0
                    else -> 1
                }
            }.joinToString("")

            if (a < b) count[a] = count.getOrDefault(a, 0) + 1
            else count[b] = count.getOrDefault(b, 0) + 1
        }

        return count.values.max()!!
    }
}