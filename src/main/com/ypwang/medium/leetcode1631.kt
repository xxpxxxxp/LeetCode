package com.ypwang.medium

class Solution1631 {
    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val m = heights.size
        val n = heights[0].size

        val avails = mutableMapOf(Pair(0, 0) to 0)
        val seen = mutableSetOf<Pair<Int, Int>>()

        while (true) {
            val pair = avails.minByOrNull { it.value }!!
            seen.add(pair.key)
            avails.remove(pair.key)
            val i = pair.key.first
            val j = pair.key.second
            val v = pair.value

            if (i == m-1 && j == n-1)
                return v

            for ((di, dj) in listOf(0 to -1, 0 to 1, 1 to 0, -1 to 0)) {
                val ni = i + di
                val nj = j + dj
                if (ni in 0 until m && nj in 0 until n && (ni to nj) !in seen) {
                    val nv = maxOf(v, Math.abs(heights[i][j] - heights[ni][nj]))
                    avails[ni to nj] = minOf(avails.getOrDefault(ni to nj, Int.MAX_VALUE), nv)
                }
            }
        }
    }
}