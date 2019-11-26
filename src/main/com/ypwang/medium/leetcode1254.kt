package com.ypwang.medium

class Solution1254 {
    class DSU(val v: Int = 0) {
        private var parent = this
        var closed = true
        set(value) {
            field = value;
            if (findParent() != this)
                findParent().closed = findParent().closed && value
        }

        fun findParent(): DSU {
            if (parent != this) parent = parent.findParent()
            return parent
        }

        fun union(that: DSU) {
            val myParent = findParent()
            val yParent = that.findParent()
            yParent.closed = myParent.closed and yParent.closed
            myParent.parent = yParent
        }
    }

    fun closedIsland(grid: Array<IntArray>): Int {
        val dsu = Array(grid.size) { i -> Array(grid[0].size){ j -> DSU(grid[i][j]) } }

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 0) {
                    dsu[i][j].closed = dsu[i][j].closed && listOf(-1 to 0, 1 to 0, 0 to 1, 0 to -1).all { (m, n) ->
                        val x = i + m
                        val y = j + n
                        x in grid.indices && y in grid[0].indices
                    }
                    for ((m, n) in listOf(1 to 0, 0 to 1)) {
                        val x = i + m
                        val y = j + n
                        if (x in grid.indices && y in grid[0].indices && grid[x][y] == 0)
                            dsu[i][j].union(dsu[x][y])
                    }
                }
            }
        }

        return dsu.sumBy { it.count { d -> d.v == 0 && d.closed && d.findParent() == d } }
    }
}

fun main() {
    println(arrayOf(
            intArrayOf(1,0,1,1,1,1,0,0,1,0),
            intArrayOf(1,0,1,1,0,0,0,1,1,1),
            intArrayOf(0,1,1,0,0,0,1,0,0,0),
            intArrayOf(1,0,1,1,0,1,0,0,1,0),
            intArrayOf(0,1,1,1,0,1,0,1,0,0),
            intArrayOf(1,0,0,1,0,0,1,0,0,0),
            intArrayOf(1,0,1,1,1,0,0,1,1,0),
            intArrayOf(1,1,0,1,1,0,1,0,1,1),
            intArrayOf(0,0,1,1,1,0,1,0,1,1),
            intArrayOf(1,0,0,1,1,1,1,0,1,1)
    ).joinToString("\n") { it.joinToString("") })

    println(Solution1254().closedIsland(arrayOf(
            intArrayOf(1,0,1,1,1,1,0,0,1,0),
            intArrayOf(1,0,1,1,0,0,0,1,1,1),
            intArrayOf(0,1,1,0,0,0,1,0,0,0),
            intArrayOf(1,0,1,1,0,1,0,0,1,0),
            intArrayOf(0,1,1,1,0,1,0,1,0,0),
            intArrayOf(1,0,0,1,0,0,1,0,0,0),
            intArrayOf(1,0,1,1,1,0,0,1,1,0),
            intArrayOf(1,1,0,1,1,0,1,0,1,1),
            intArrayOf(0,0,1,1,1,0,1,0,1,1),
            intArrayOf(1,0,0,1,1,1,1,0,1,1)
    )))
    println(Solution1254().closedIsland(arrayOf(
            intArrayOf(1,1,1,1,1,1,1,0),intArrayOf(1,0,0,0,0,1,1,0),intArrayOf(1,0,1,0,1,1,1,0),intArrayOf(1,0,0,0,0,1,0,1),intArrayOf(1,1,1,1,1,1,1,0)
    )))
    println(Solution1254().closedIsland(arrayOf(
            intArrayOf(0,0,1,0,0),intArrayOf(0,1,0,1,0),intArrayOf(0,1,1,1,0)
    )))
    println(Solution1254().closedIsland(arrayOf(
            intArrayOf(1,1,1,1,1,1,1),
                    intArrayOf(1,0,0,0,0,0,1),
                    intArrayOf(1,0,1,1,1,0,1),
                    intArrayOf(1,0,1,0,1,0,1),
                    intArrayOf(1,0,1,1,1,0,1),
                    intArrayOf(1,0,0,0,0,0,1),
                    intArrayOf(1,1,1,1,1,1,1)
    )))
}