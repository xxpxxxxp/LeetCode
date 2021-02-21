package com.ypwang.medium

class Solution1765 {
    fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
        val m = isWater.size
        val n = isWater[0].size

        val seen = Array(m) { BooleanArray(n) }
        var queue = isWater.withIndex().flatMap { (i, arr) ->
            arr.withIndex().filter { (_, v) -> v == 1 }.map { (j, _) ->
                seen[i][j] = true
                isWater[i][j] = 0
                i to j
            }
        }

        var height = 1
        while (queue.isNotEmpty()) {
            val next = mutableListOf<Pair<Int, Int>>()

            for ((i, j) in queue) {
                for ((di, dj) in listOf(-1 to 0, 1 to 0, 0 to 1, 0 to -1)) {
                    val x = i + di
                    val y = j + dj
                    if (x in 0 until m && y in 0 until n && !seen[x][y]) {
                        isWater[x][y] = height
                        seen[x][y] = true
                        next.add(x to y)
                    }
                }
            }

            queue = next
            height++
        }

        return isWater
    }
}