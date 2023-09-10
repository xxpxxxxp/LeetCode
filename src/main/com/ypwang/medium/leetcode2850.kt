package com.ypwang.medium

class Solution2850 {
    fun minimumMoves(grid: Array<IntArray>): Int =
        solve(grid)

    private fun solve(grid: Array<IntArray>): Int {
        val extras = mutableListOf<IntArray>()
        val zeros = mutableListOf<IntArray>()
        for (i in 0..2) {
            for (j in 0..2) {
                if (grid[i][j] == 0)
                    zeros.add(intArrayOf(i, j))
                else if (grid[i][j] > 1)
                    extras.add(intArrayOf(i, j))
            }
        }

        if (zeros.isEmpty())
            return 0
        var minSteps = 1000000
        for ((z1, z2) in zeros) {
            for ((e1, e2) in extras) {
                val distance = Math.abs(z1 - e1) + Math.abs(z2 - e2)
                grid[z1][z2] = 1
                grid[e1][e2]--
                minSteps = minOf(minSteps, distance + solve(grid))
                grid[z1][z2] = 0
                grid[e1][e2]++
            }
        }
        return minSteps
    }
}