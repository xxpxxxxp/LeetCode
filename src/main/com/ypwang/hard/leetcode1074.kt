package com.ypwang.hard

class Solution1074 {
    fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
        for (row in matrix) {
            var sum = 0
            for (i in row.indices) {
                sum += row[i]
                row[i] = sum
            }
        }

        var rst = 0
        for (i in matrix[0].indices) {
            for (j in i until matrix[0].size) {
                val map = mutableMapOf(0 to 1)
                var sum = 0

                for (k in matrix.indices) {
                    sum += matrix[k][j]
                    if (i > 0) sum -= matrix[k][i-1]
                    rst += map.getOrDefault(sum - target, 0)
                    map[sum] = map.getOrDefault(sum, 0) + 1
                }
            }
        }

        return rst
    }
}

fun main() {
    println(Solution1074().numSubmatrixSumTarget(arrayOf(
            intArrayOf(0,1,0), intArrayOf(1,1,1), intArrayOf(0,1,0)
    ), 0))
}