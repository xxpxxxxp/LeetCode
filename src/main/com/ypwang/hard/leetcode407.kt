package com.ypwang.hard

class Solution407 {
    fun trapRainWater(heightMap: Array<IntArray>): Int {
        if (heightMap.isEmpty()) return 0

        val m = heightMap.size
        val n = heightMap[0].size

        if (m < 3 || n < 3) return 0

        for (i in 1 until m-1) {
            for (j in 1 until n-1) {
                heightMap[i][j] = heightMap[i][j] + (20000 shl 16)
            }
        }

        val incs = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
        fun bleed(x: Int, y: Int, value: Int) {
            for (inc in incs) {
                val nx = x + inc.first
                val ny = y + inc.second

                if (nx in 1 until m-1 && ny in 1 until n-1 && (heightMap[nx][ny] shr 16) > value) {
                    val v = heightMap[nx][ny] and 0xffff
                    heightMap[nx][ny] = v + (value shl 16)
                    bleed(nx, ny, maxOf(value, v))
                }
            }
        }

        // bleed
        for (i in 1 until m-1) {
            bleed(i, 0, heightMap[i][0])
            bleed(i, n-1, heightMap[i][n-1])
        }

        for (j in 1 until n-1) {
            bleed(0, j, heightMap[0][j])
            bleed(m-1, j, heightMap[m-1][j])
        }

        var total = 0
        for (i in 1 until m-1) {
            for (j in 1 until n-1) {
                val cap = heightMap[i][j] shr 16
                val h = heightMap[i][j] and 0xffff
                if (cap > h) total += cap - h
            }
        }

        return total
    }
}

fun main() {
    println(Solution407().trapRainWater(arrayOf(
            intArrayOf(1,4,3,1,3,2), intArrayOf(3,2,1,3,2,4), intArrayOf(2,3,3,2,3,1)
    )))
}