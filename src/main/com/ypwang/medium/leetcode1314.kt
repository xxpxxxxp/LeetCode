package com.ypwang.medium

class Solution1314 {
    fun matrixBlockSum(mat: Array<IntArray>, K: Int): Array<IntArray> {
        val m = mat.size
        val n = mat[0].size

        val cache = Array(m){ IntArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                var r = mat[i][j]
                if (i > 0) r += cache[i-1][j]
                if (j > 0) r += cache[i][j-1]
                if (i > 0 && j > 0) r-= cache[i-1][j-1]
                cache[i][j] = r
            }
        }

        val rst = Array(m){ IntArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                val bottom = minOf(i + K, m - 1)
                val right = minOf(j + K, n - 1)

                var r = cache[bottom][right]
                if (i - K > 0) r -= cache[i - K - 1][right]
                if (j - K > 0) r -= cache[bottom][j - K - 1]
                if (i - K > 0 && j - K > 0) r += cache[i - K - 1][j - K - 1]
                rst[i][j] = r
            }
        }

        return rst
    }
}

fun main() {
    println(Solution1314().matrixBlockSum(arrayOf(
            intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9)
    ), 1).map { it.toList() })
    println(Solution1314().matrixBlockSum(arrayOf(
            intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9)
    ), 2).map { it.toList() })
}