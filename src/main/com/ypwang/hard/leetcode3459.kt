package com.ypwang.hard

class Solution3459 {
    private val ds = arrayOf(
        intArrayOf(1, 1),
        intArrayOf(1, -1),
        intArrayOf(-1, -1),
        intArrayOf(-1, 1)
    )
    private val nx = intArrayOf(2, 2, 0)

    fun lenOfVDiagonal(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size
        val cache = mutableMapOf<String, Int>()

        // i, j current idx
        // x current expect value, 2,0,2,0,...
        // d direction index in ds
        // k how many turn left
        fun dp(i: Int, j: Int, x: Int, d: Int, k: Int): Int {
            if (i !in 0 until n || j !in 0 until m)
                return 0

            if (grid[i][j] != x)
                return 0

            val key = "$i,$j,$x,$d,$k"
            if (key in cache)
                return cache[key]!!

            var rst = dp(i + ds[d][0], j + ds[d][1], nx[x], d, k) + 1
            if (k > 0) {
                val d2 = (d + 1) % 4
                rst = maxOf(rst, dp(i + ds[d2][0], j + ds[d2][1], nx[x], d2, 0) + 1)
            }

            cache[key] = rst
            return rst
        }

        var result = 0
        for (i in 0 until n)
            for (j in 0 until m)
                if (grid[i][j] == 1)
                    for (d in 0 until 4)
                        result = maxOf(result, dp(i, j, 1, d, 1))

        return result
    }
}
