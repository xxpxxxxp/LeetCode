package com.ypwang.medium

class Solution1605 {
    fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
        val rst = Array(rowSum.size){ IntArray(colSum.size) }

        for (i in rowSum.indices) {
            for (j in colSum.indices) {
                val t = minOf(rowSum[i], colSum[j])
                rst[i][j] = t
                rowSum[i] -= t
                colSum[j] -= t
            }
        }

        return rst
    }
}