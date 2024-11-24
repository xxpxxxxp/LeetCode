package com.ypwang.hard

class Solution3363 {
    fun maxCollectedFruits(fruits: Array<IntArray>): Int {
        val n = fruits.size
        // Set inaccessible cells to 0
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i < j && j < n - 1 - i) {
                    fruits[i][j] = 0
                }
                if (j < i && i < n - 1 - j) {
                    fruits[i][j] = 0
                }
            }
        }

        // First child
        var res = 0
        for (i in 0 until n)
            res += fruits[i][i]

        // Second child
        for (i in 1 until n)
            for (j in i + 1 until n)
                fruits[i][j] += maxOf(fruits[i - 1][j - 1], maxOf(fruits[i - 1][j], if (j + 1 < n) fruits[i - 1][j + 1] else 0))

        // Third child
        for (j in 1 until n)
            for (i in j + 1 until n)
                fruits[i][j] += maxOf(fruits[i - 1][j - 1], maxOf(fruits[i][j - 1], if (i + 1 < n) fruits[i + 1][j - 1] else 0))

        return res + fruits[n - 1][n - 2] + fruits[n - 2][n - 1]
    }
}
