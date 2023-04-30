package com.ypwang.medium

class Solution2661 {
    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size
        val rows = IntArray(m)
        val cols = IntArray(n)

        val pos = mutableMapOf<Int, Pair<Int, Int>>()
        for (i in 0 until m)
            for (j in 0 until n)
                pos[mat[i][j]] = i to j

        for ((z, v) in arr.withIndex()) {
            val (i, j) = pos[v]!!
            rows[i]++
            cols[j]++
            if (rows[i] == n || cols[j] == m)
                return z
        }
        return -1
    }
}
