package com.ypwang.medium

class Solution63 {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        if (obstacleGrid.isEmpty()) {
            return 0
        }

        if (obstacleGrid[0][0] == 1)
            return 0
        else obstacleGrid[0][0] = 1

        val y = obstacleGrid.size
        val x = obstacleGrid[0].size

        for (i in 0 until x) {
            for (j in 0 until y) {
                if (i == 0 && j == 0)
                    continue

                if (obstacleGrid[j][i] == 1) {
                    obstacleGrid[j][i] = -1
                    continue
                }

                val left = if (j < 1 || obstacleGrid[j-1][i] == -1) 0 else obstacleGrid[j-1][i]
                val right = if (i < 1 || obstacleGrid[j][i-1] == -1) 0 else obstacleGrid[j][i-1]
                obstacleGrid[j][i] = left + right
            }
        }

        return Math.max(obstacleGrid[y-1][x-1], 0)
    }
}

fun main(args: Array<String>) {
    println(Solution63().uniquePathsWithObstacles(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0))))
}