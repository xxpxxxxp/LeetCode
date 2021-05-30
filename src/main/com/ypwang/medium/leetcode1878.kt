package com.ypwang.medium

class Solution1878 {
    fun getBiggestThree(grid: Array<IntArray>): IntArray {
        fun helper(i: Int, j: Int, len: Int): Pair<Int, Boolean> {
            if (len == 0)
                return grid[i][j] to true

            var sum = 0
            var cx = i
            var cy = j
            for ((dx, dy) in listOf(1 to -1, 1 to 1, -1 to 1, -1 to -1)) {
                for (_c in 0 until len) {
                    sum += grid[cx][cy]
                    cx += dx
                    cy += dy

                    if (cx !in grid.indices || cy !in grid[0].indices)
                        return 0 to false
                }
            }

            return sum to true
        }

        val set = mutableSetOf<Int>()
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                var len = 0
                while (true) {
                    val (sum, ok) = helper(i, j, len++)
                    if (!ok)
                        break

                    set.add(sum)
                    if (set.size > 3)
                        set.remove(set.min()!!)
                }
            }
        }

        return set.sortedDescending().toIntArray()
    }
}