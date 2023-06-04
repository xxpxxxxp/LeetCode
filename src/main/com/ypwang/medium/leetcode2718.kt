package com.ypwang.medium

class Solution2718 {
    fun matrixSumQueries(n: Int, queries: Array<IntArray>): Long {
        val row = BooleanArray(n)
        val col = BooleanArray(n)
        var rst = 0L
        var rowLeft = n
        var colLeft = n
        for ((t, i, v) in queries.reversed()) {
            if (t == 0 && !row[i]) {
                rst += colLeft * v
                row[i] = true
                rowLeft--
            }
            if (t == 1 && !col[i]) {
                rst += rowLeft * v
                col[i] = true
                colLeft--
            }
        }
        return rst
    }
}