package com.ypwang.medium

class Solution2536 {
    fun rangeAddQueries(n: Int, queries: Array<IntArray>): Array<IntArray> {
        val mat = Array(n) { IntArray(n) }
        for ((r1, c1, r2, c2) in queries) {
            for (i in r1..r2) {
                mat[i][c1]++
                if (c2+1 < n)
                    mat[i][c2+1]--
            }
        }

        for (i in 0 until n) {
            for (j in 1 until n)
                mat[i][j] += mat[i][j-1]
        }

        return mat
    }
}