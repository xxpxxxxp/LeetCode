package com.ypwang.hard

class Solution2713 {
    fun maxIncreasingCells(M: Array<IntArray>): Int {
        val m = M.size
        val n = M[0].size
        val A = mutableMapOf<Int, MutableList<IntArray>>()
        for (i in 0 until m)
            for (j in 0 until n)
                A.getOrPut(M[i][j]) { mutableListOf() }.add(intArrayOf(i, j))

        val dp = Array(m) { IntArray(n) }
        val res = IntArray(n + m)
        for ((_, idx) in A.toList().sortedBy { it.first }) {
            for ((i, j) in idx)
                dp[i][j] = maxOf(res[i], res[m + j]) + 1

            for ((i, j) in idx) {
                res[m + j] = maxOf(res[m + j], dp[i][j])
                res[i] = maxOf(res[i], dp[i][j])
            }
        }
        return res.max()!!
    }
}
