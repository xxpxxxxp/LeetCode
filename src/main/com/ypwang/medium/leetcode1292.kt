package com.ypwang.medium

class Solution1292 {
    fun maxSideLength(mat: Array<IntArray>, threshold: Int): Int {
        val m = mat.size
        val n = mat[0].size

        val prefix = Array(m+1){ IntArray(n+1) }

        for (i in 1..m) {
            for (j in 1..n) {
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + mat[i-1][j-1]
            }
        }

        fun exist(len: Int): Boolean {
            for (i in len..m) {
                for (j in len..n) {
                    if (prefix[i][j] + prefix[i-len][j-len] - prefix[i-len][j] - prefix[i][j-len] <= threshold)
                        return true
                }
            }
            return false
        }

        var left = 0
        var right = minOf(m, n)
        while (left < right) {
            val mid = (left + right + 1) / 2
            if (exist(mid)) left = mid
            else right = mid - 1
        }

        return left
    }
}

fun main() {
    println(Solution1292().maxSideLength(arrayOf(
            intArrayOf(18,70), intArrayOf(61,1), intArrayOf(25,85),
            intArrayOf(14,40), intArrayOf(11,96), intArrayOf(97,96), intArrayOf(63,45)
    ), 40184))
}