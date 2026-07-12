package com.ypwang.medium

class Solution3988 {
    fun createGrid(m: Int, n: Int, k: Int): Array<String> {
        val grid = Array(m) { CharArray(n) { '#' } }

        // Single row or single column
        if (m == 1 || n == 1) {
            if (k != 1) return emptyArray()

            for (i in 0 until m)
                for (j in 0 until n)
                    grid[i][j] = '.'

            return grid.map { String(it) }.toTypedArray()
        }

        // Two rows or two columns
        if (m == 2 || n == 2) {
            val len = maxOf(m, n)

            if (k > len)
                return emptyArray()

            if (m == 2) {
                // Open the entire first row
                for (j in 0 until n)
                    grid[0][j] = '.'

                // Open last k cells of second row
                for (j in n - 1 downTo n - k)
                    grid[1][j] = '.'
            } else {
                // Open the entire first column
                for (i in 0 until m)
                    grid[i][0] = '.'

                // Open last k cells of second column
                for (i in m - 1 downTo m - k)
                    grid[i][1] = '.'
            }

            return grid.map { String(it) }.toTypedArray()
        }

        val startRow = m - 3
        val startCol = n - 3

        val pattern = when (k) {
            1 -> listOf(
                "...",
                "##.",
                "##."
            )

            2 -> listOf(
                "...",
                "#..",
                "##."
            )

            3 -> listOf(
                "...",
                "#..",
                "#.."
            )

            4 -> listOf(
                "..#",
                "...",
                "#.."
            )

            else -> emptyList()
        }

        // Create the path
        for (i in 0..startRow)
            grid[i][startCol] = '.'

        for (j in 0..startCol)
            grid[0][j] = '.'

        // Copy the 3×3 pattern
        for (i in 0 until 3)
            for (j in 0 until 3)
                grid[startRow + i][startCol + j] = pattern[i][j]

        return grid.map { String(it) }.toTypedArray()
    }
}
