package com.ypwang.hard

class Solution803 {
    fun hitBricks(grid: Array<IntArray>, hits: Array<IntArray>): IntArray {
        val copy = grid.map { it.clone() }.toTypedArray()
        hits.forEach { copy[it[0]][it[1]] = 0 }

        val parent = IntArray(grid.size * grid[0].size + 1){ it }
        val rank = IntArray(grid.size * grid[0].size + 1)
        val sz = IntArray(grid.size * grid[0].size + 1){1}

        fun find(x: Int): Int {
            if (parent[x] != x) parent[x] = find(parent[x])
            return parent[x]
        }

        fun union(x: Int, y: Int) {
            var xr = find(x)
            var yr = find(y)
            if (xr == yr) return

            if (rank[xr] < rank[yr]) {
                val tmp = yr
                yr = xr
                xr = tmp
            }
            if (rank[xr] == rank[yr])
                rank[xr]++

            parent[yr] = xr
            sz[xr] += sz[yr]
        }

        fun top() = sz[find(sz.lastIndex)] - 1

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (copy[i][j] == 1) {
                    val idx = i * grid[0].size + j
                    if (i == 0) union(idx, parent.lastIndex)
                    if (i > 0 && copy[i-1][j] == 1) union(idx, idx - grid[0].size)
                    if (j > 0 && copy[i][j-1] == 1) union(idx, idx - 1)
                }
            }
        }

        val rst = mutableListOf<Int>()
        for ((x, y) in hits.reversed()) {
            if (grid[x][y] == 0) rst.add(0)
            else {
                val c = top()
                val idx = x * grid[0].size + y

                for ((dx, dy) in listOf(-1 to 0, 1 to 0, 0 to 1, 0 to -1)) {
                    val cx = x + dx
                    val cy = y + dy
                    if (cx in grid.indices && cy in grid[0].indices && copy[cx][cy] == 1)
                        union(idx, cx * grid[0].size + cy)
                }

                if (x == 0) union(idx, parent.lastIndex)
                copy[x][y] = 1
                rst.add(maxOf(0, top() - c - 1))
            }
        }

        return rst.reversed().toIntArray()
    }
}

fun main() {
    println(Solution803().hitBricks(arrayOf(intArrayOf(0,1,1,1,1,1), intArrayOf(1,1,1,1,1,1), intArrayOf(0,0,1,0,0,0), intArrayOf(0,0,0,0,0,0), intArrayOf(0,0,0,0,0,0)), arrayOf(intArrayOf(1,1), intArrayOf(0,4), intArrayOf(0,2))).toList())
    println(Solution803().hitBricks(arrayOf(intArrayOf(1,0,0,0), intArrayOf(1,1,1,0)), arrayOf(intArrayOf(1,0))).toList())
    println(Solution803().hitBricks(arrayOf(intArrayOf(1,0,0,0), intArrayOf(1,1,0,0)), arrayOf(intArrayOf(1,1), intArrayOf(1,0))).toList())
}