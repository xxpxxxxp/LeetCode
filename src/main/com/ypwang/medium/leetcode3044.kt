package com.ypwang.medium

class Solution3044 {
    fun mostFrequentPrime(mat: Array<IntArray>): Int {
        val res = mutableListOf<Int>()
        val n = mat.size
        val m = mat[0].size
        val dx = intArrayOf(0, 0, 1, 1, 1, -1, -1, -1)
        val dy = intArrayOf(1, -1, 0, 1, -1, -1, 0, 1)

        for (i in 0 until n)
            for (j in 0 until m)
                for (dir in 0..7)
                    dfs(res, 0, i, j, dx[dir], dy[dir], mat)

        val map = mutableMapOf<Int, Int>()
        for (num in res) {
            if (num < 10 || !isPrime(num))
                continue
            map[num] = map.getOrDefault(num, 0) + 1
        }

        var maxCount = 0
        var max = -1
        for (key in map.keys) {
            if (map[key]!! > maxCount) {
                maxCount = map[key]!!
                max = key
            } else if (map[key] == maxCount) {
                max = maxOf(key, max)
            }
        }
        return max
    }

    private fun dfs(res: MutableList<Int>, pre: Int, i: Int, j: Int, dirX: Int, dirY: Int, mat: Array<IntArray>) {
        if (i < 0 || i >= mat.size || j < 0 || j >= mat[0].size)
            return
        val num = pre * 10 + mat[i][j]
        res.add(num)
        dfs(res, num, i + dirX, j + dirY, dirX, dirY, mat)
    }

    private fun isPrime(n: Int): Boolean {
        if (n <= 1)
            return false
        return (2 until n).all { n % it > 0 }
    }
}
