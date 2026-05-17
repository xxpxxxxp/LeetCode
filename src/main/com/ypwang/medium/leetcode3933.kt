package com.ypwang.medium

class Solution3933 {
    fun countLocalMaximums(matrix: Array<IntArray>): Int {
        val m = matrix.size
        val n = matrix[0].size

        var ans = 0
        val pfx = Array(201) { Array(m + 1) { IntArray(n + 1) } }

        for (v in 0..200) {
            for (i in 0 until m) {
                var rowSum = 0

                for (j in 0 until n) {
                    if (matrix[i][j] > v)
                        rowSum++

                    pfx[v][i + 1][j + 1] = rowSum + pfx[v][i][j + 1]
                }
            }
        }

        fun check(i: Int, j: Int, mat: Array<IntArray>): Boolean {
            val value = mat[i][j]

            val r1 = maxOf(0, i - value)
            val r2 = minOf(m - 1, i + value)
            val c1 = maxOf(0, j - value)
            val c2 = minOf(n - 1, j + value)

            var cnt =
                pfx[value][r2 + 1][c2 + 1] -
                        pfx[value][r1][c2 + 1] +
                        pfx[value][r1][c1] -
                        pfx[value][r2 + 1][c1]

            val dr = intArrayOf(-value, -value, value, value)
            val dc = intArrayOf(-value, value, -value, value)

            for (k in 0 until 4) {
                val ni = i + dr[k]
                val nj = j + dc[k]

                if (ni in 0 until m && nj in 0 until n && mat[ni][nj] > value) {
                    cnt--
                }
            }

            return cnt == 0
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == 0)
                    continue

                if (check(i, j, matrix)) {
                    ans++
                }
            }
        }

        return ans
    }
}
