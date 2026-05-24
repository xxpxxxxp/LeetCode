package com.ypwang.medium

class Solution3938 {
    fun maxScore(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        var ans = Int.MIN_VALUE

        // Check all horizontal subarrays
        for (i in 0 until m) {
            val pfx = IntArray(n + 1)

            for (j in 0 until n)
                pfx[j + 1] = pfx[j] + grid[i][j]

            for (j in 0 until n) {
                for (k in j until n) {
                    val sum = pfx[k + 1] - pfx[j]
                    val len = k - j + 1

                    if (len >= 2)
                        ans = maxOf(ans, sum)
                    else if (len == 1) {
                        if (i > 0 && i < m - 1 && j > 0 && j < n - 1)
                            ans = maxOf(ans, sum)
                    }
                }
            }
        }

        // Check all vertical subarrays
        for (j in 0 until n) {
            val pfx = IntArray(m + 1)

            for (i in 0 until m)
                pfx[i + 1] = pfx[i] + grid[i][j]

            for (i in 0 until m) {
                for (k in i until m) {
                    val sum = pfx[k + 1] - pfx[i]
                    val len = k - i + 1

                    if (len >= 2)
                        ans = maxOf(ans, sum)
                    else if (len == 1) {
                        if (i > 0 && i < m - 1 && j > 0 && j < n - 1)
                            ans = maxOf(ans, sum)
                    }
                }
            }
        }

        return ans
    }
}
