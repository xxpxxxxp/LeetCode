package com.ypwang.medium

class Solution3240 {
    fun minFlips(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        var res = 0 // Minimum changes required in 4-way symmetry
        var single = 0 // Number of (1, 0) pair in a 2-way symmetry
        var double = 0 // Number of (1, 1) pair in a 2-way symmetry

        // Process 4-way symmetry
        for (i in 0 until m / 2) {
            for (j in 0 until n / 2) {
                val ones = grid[i][j] + grid[i][n - 1 - j] + grid[m - 1 - i][j] + grid[m - 1 - i][n - 1 - j]
                res += minOf(ones, 4 - ones)
            }
            // Process the middle column if it exists (2-way symmetry)
            if (n % 2 == 1) {
                val ones = grid[i][n / 2] + grid[m - 1 - i][n / 2]
                single += if (ones == 1) 1 else 0
                double += if (ones == 2) 1 else 0
            }
        }

        // Process the middle row if it exists (2-way symmetry)
        if (m % 2 == 1) {
            for (j in 0 until n / 2) {
                val ones = grid[m / 2][j] + grid[m / 2][n - 1 - j]
                single += if (ones == 1) 1 else 0
                double += if (ones == 2) 1 else 0
            }
            if (n % 2 == 1) {
                res += grid[m / 2][n / 2] // Center cell needs to be 0 if it's 1
            }
        }

        // Adjust based on the number of (1, 1) pairs:
        return if (double % 2 == 0 || single > 0) {
            res + single
        } else {
            res + 2
        }
    }
}
