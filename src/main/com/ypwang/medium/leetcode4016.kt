package com.ypwang.medium

class Solution4016 {
    fun maxArea(mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size

        val pref = Array(m + 1) { IntArray(n + 1) }
        for (i in 0 until m)
            for (j in 0 until n)
                pref[i + 1][j + 1] = mat[i][j] + pref[i][j + 1] + pref[i + 1][j] - pref[i][j]

        var low = 1
        var high = minOf(m, n)
        var ans = 0
        while (low <= high) {
            val k = low + (high - low) / 2

            if (canPlaceTwo(k, mat, pref)) {
                ans = k
                low = k + 1
            } else {
                high = k - 1
            }
        }
        return ans * ans
    }

    private fun canPlaceTwo(k: Int, mat: Array<IntArray>, pref: Array<IntArray>): Boolean {
        val m = mat.size
        val n = mat[0].size

        var minRow = Int.MAX_VALUE
        var maxRow = Int.MIN_VALUE

        var minCol = Int.MAX_VALUE
        var maxCol = Int.MIN_VALUE

        var found = false

        var r = 0
        while (r + k <= m) {
            var c = 0
            while (c + k <= n) {
                // Sum of k x k square
                val sum =
                    ((pref[r + k][c + k]
                            - pref[r][c + k]
                            - pref[r + k][c])
                            + pref[r][c])

                // All cells must be 1
                if (sum == k * k) {
                    found = true

                    minRow = minOf(minRow, r)
                    maxRow = maxOf(maxRow, r)

                    minCol = minOf(minCol, c)
                    maxCol = maxOf(maxCol, c)
                }
                c++
            }
            r++
        }

        if (!found)
            return false

        // Two squares can be separated vertically
        if (maxRow - minRow >= k)
            return true

        // Two squares can be separated horizontally
        if (maxCol - minCol >= k)
            return true

        return false
    }
}
