package com.ypwang.medium

class Solution1020 {
    fun numEnclaves(A: Array<IntArray>): Int {
        if (A.isEmpty())
            return 0

        val m = A.size
        val n = A[0].size

        fun turn(i: Int, j: Int) {
            A[i][j] = 2

            if (i > 1 && A[i-1][j] == 1)
                turn(i - 1, j)

            if (i < m-1 && A[i+1][j] == 1)
                turn(i + 1, j)

            if (j > 1 && A[i][j-1] == 1)
                turn(i, j - 1)

            if (j < n-1 && A[i][j+1] == 1)
                turn(i, j + 1)
        }

        for (j in 0 until n) {
            if (A[0][j] == 1) {
                turn(0, j)
            }
            if (A[m-1][j] == 1) {
                turn(m-1, j)
            }
        }

        for (i in 0 until m) {
            if (A[i][0] == 1) {
                turn(i, 0)
            }
            if (A[i][n-1] == 1) {
                turn(i, n-1)
            }
        }

        return A.sumBy { it.count { it == 1 } }
    }
}