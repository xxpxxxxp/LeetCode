package com.ypwang.medium

class Solution3567 {
    fun getMin(g: Array<IntArray>, k: Int, x: Int, y: Int): Int {
        val temp = IntArray(k * k)
        var st = 0
        for (i in 0..<k)
            for (j in 0..<k)
                temp[st++] = g[i + x]!![j + y]

        temp.sort()
        var diff = Int.Companion.MAX_VALUE
        var i = 1
        while (i < k * k) {
            while (i < k * k && temp[i] == temp[i - 1])
                i++
            if (i < k * k)
                diff = minOf(diff, Math.abs(temp[i] - temp[i - 1]))
            i++
        }
        return diff
    }

    fun minAbsDiff(grid: Array<IntArray>, k: Int): Array<IntArray> {
        val m = grid.size
        val n = grid[0].size
        val ans = Array(m - k + 1) { IntArray(n - k + 1) }
        for (i in 0..m - k) {
            for (j in 0..n - k) {
                val temp = getMin(grid, k, i, j)
                ans[i][j] = if (temp == Int.Companion.MAX_VALUE) 0 else temp
            }
        }
        return ans
    }
}
