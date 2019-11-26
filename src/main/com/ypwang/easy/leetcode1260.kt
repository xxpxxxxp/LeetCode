package com.ypwang.easy

class Solution1260 {
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val m = grid.size
        val n = grid[0].size

        val rst = Array(m) { IntArray(n) }

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                rst[i][j] = grid[(i + m - (k / n + if (j < k % n) 1 else 0) % m) % m][(j + n - k % n) % n]
            }
        }

        return rst.map { it.toList() }
    }
}

fun main() {
    println(Solution1260().shiftGrid(arrayOf(
            intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9)
    ), 1))
    println(Solution1260().shiftGrid(arrayOf(
            intArrayOf(3,8,1,9), intArrayOf(19,7,2,5), intArrayOf(4,6,11,10), intArrayOf(12,0,21,13)
    ), 4))
    println(Solution1260().shiftGrid(arrayOf(
            intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9)
    ), 9))
}