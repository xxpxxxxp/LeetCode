package com.ypwang.medium

class Solution200 {
    data class DSU(val value: Char) {
        var point: DSU = this
    }

    fun root(x: DSU): DSU {
        if (x.point !== x) {
            x.point = root(x.point)
        }
        return x.point
    }

    fun union(x: DSU, y: DSU) {
        root(x).point = root(y)
    }

    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty())
            return 0

        val m = grid.size
        val n = grid[0].size

        val dsus = Array(m * n){ DSU(grid[it/n][it%n]) }

        for (i in 0 until m) {
            for (j in 0 until n) {
                val cur = dsus[i * n + j]
                if (cur.value == '1') {
                    if (i > 1 && dsus[(i - 1) * n + j].value == '1')
                        union(cur, dsus[(i - 1) * n + j])
                    if (i < m - 1 && dsus[(i + 1) * n + j].value == '1')
                        union(cur, dsus[(i + 1) * n + j])
                    if (j > 1 && dsus[i * n + j - 1].value == '1')
                        union(cur, dsus[i * n + j - 1])
                    if (j < n - 1 && dsus[i * n + j + 1].value == '1')
                        union(cur, dsus[i * n + j + 1])
                }
            }
        }

        return dsus.count { it.point === it && it.value == '1' }
    }
}

fun main() {
    println(Solution200().numIslands(arrayOf(
            "11110".toCharArray(), "11010".toCharArray(), "11000".toCharArray(), "00000".toCharArray()
    )))
}