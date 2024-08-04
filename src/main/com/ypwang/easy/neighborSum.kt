package com.ypwang.easy

class neighborSum(val grid: Array<IntArray>) {
    val n = grid.size
    val mapping = IntArray(n * n)
    init {
        for (i in 0 until n) {
            for (j in 0 until n)
                mapping[grid[i][j]] = i * n + j
        }
    }

    fun adjacentSum(value: Int): Int {
        val idx = mapping[value]
        val i = idx / n
        val j = idx % n

        var rst = 0
        for ((dx, dy) in listOf(0 to -1, 0 to 1, 1 to 0, -1 to 0)) {
            val x = i + dx
            val y = j + dy

            if (x in 0 until n && y in 0 until n)
                rst += grid[x][y]
        }

        return rst
    }

    fun diagonalSum(value: Int): Int {
        val idx = mapping[value]
        val i = idx / n
        val j = idx % n

        var rst = 0
        for ((dx, dy) in listOf(1 to -1, 1 to 1, -1 to -1, -1 to 1)) {
            val x = i + dx
            val y = j + dy

            if (x in 0 until n && y in 0 until n)
                rst += grid[x][y]
        }

        return rst
    }
}
