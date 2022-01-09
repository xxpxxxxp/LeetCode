package com.ypwang.hard

class Solution2132 {
    fun possibleToStamp(M: Array<IntArray>, h: Int, w: Int): Boolean {
        //M[i][j] can be coverd by any stamp with right-bottom point
        //in the sub-matrix from (i,j) to (i + w - 1, j + h - 1).
        val m = M.size
        val n = M[0].size

        // A[i][j] means the total empty points in the rectangle, with top-left at (0, 0) and right-bottom at (i - 1, j - 1).
        val A = Array(m + 1) { IntArray(n + 1) }
        // B[i][j] means the sub-martix is all empty, with top-left at (0, 0) and right-bottom at (i - 1, j - 1)
        val B = Array(m + 1) { IntArray(n + 1) }
        // good[i][j] means it fits a stamp with stamp right-bottom at (i, j)
        val good = Array(m) { IntArray(n) }

        for (i in 0 until m) {
            for (j in 0 until n) {
                A[i + 1][j + 1] = A[i + 1][j] + A[i][j + 1] - A[i][j] + (1 - M[i][j])
                if (i + 1 >= h && j + 1 >= w) {
                    val x = i + 1 - h
                    val y = j + 1 - w
                    if (A[i + 1][j + 1] - A[x][j + 1] - A[i + 1][y] + A[x][y] == w * h)
                        good[i][j]++
                }
            }
        }

        for (i in 0 until m)
            for (j in 0 until n)
                B[i + 1][j + 1] = B[i + 1][j] + B[i][j + 1] - B[i][j] + good[i][j]

        for (i in 0 until m) {
            for (j in 0 until n) {
                val x = minOf(i + h, m)
                val y = minOf(j + w, n)
                if (M[i][j] == 0 && B[x][y] - B[i][y] - B[x][j] + B[i][j] == 0)
                    return false
            }
        }

        return true
    }
}