package com.ypwang.hard

class Solution85 {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty()) return 0

        val m = matrix.size
        val n = matrix[0].size

        val dp = Array(m) { IntArray(n) }

        var max = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] != '0') {
                    // up part
                    val up = if (i > 0 && matrix[i-1][j] == '1') ((dp[i-1][j] shr 24) and 0xff) + 1 else 1
                    // left part
                    val left = if (j > 0 && matrix[i][j-1] == '1') ((dp[i][j-1] shr 16) and 0xff) + 1 else 1
                    // finally, rectangle part
                    val rectUp = minOf(up, if (i > 0 && j > 0) ((dp[i-1][j-1] shr 8) and 0xff) + 1 else Int.MAX_VALUE)
                    val rectLeft = minOf(left, if (i > 0 && j > 0) (dp[i-1][j-1] and 0xff) + 1 else Int.MAX_VALUE)
                    val curMax = maxOf(up, left, rectUp * rectLeft)
                    if (curMax > max) max = curMax
                    dp[i][j] = (up shl 24) + (left shl 16) + (rectUp shl 8) + rectLeft
                }
            }
        }

        return max
    }
}

fun main() {
    println(Solution85().maximalRectangle(arrayOf(
            "1010".toCharArray(),
            "1011".toCharArray(),
            "1011".toCharArray(),
            "1111".toCharArray()
    )))
}