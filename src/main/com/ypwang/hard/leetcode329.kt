package com.ypwang.hard

class Solution329 {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        if (matrix.isEmpty()) return 0

        val m = matrix.size
        val n = matrix[0].size
        val cache = Array(m){ IntArray(n){-1} }

        var max = 0
        fun dfs(x: Int, y: Int): Int {
            if (cache[x][y] >= 0) return cache[x][y]
            val t = matrix[x][y]
            var path = 1
            if (x > 0 && matrix[x-1][y] > t) {
                path = 1 + dfs(x-1, y)
            }
            if (x < m-1 && matrix[x+1][y] > t) {
                path = maxOf(path, 1 + dfs(x+1, y))
            }
            if (y > 0 && matrix[x][y-1] > t) {
                path = maxOf(path, 1 + dfs(x, y-1))
            }
            if (y < n-1 && matrix[x][y+1] > t) {
                path = maxOf(path, 1 + dfs(x, y+1))
            }

            cache[x][y] = path
            max = maxOf(max, path)
            return path
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (cache[i][j] < 0)
                    dfs(i, j)
            }
        }

        return max
    }
}

fun main() {
    println(Solution329().longestIncreasingPath(arrayOf(
            intArrayOf(9,9,4), intArrayOf(6,6,8), intArrayOf(2,1,1)
    )))
}