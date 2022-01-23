package com.ypwang.medium

import java.util.*

class Solution2146{
    fun highestRankedKItems(grid: Array<IntArray>, pricing: IntArray, start: IntArray, k: Int): List<List<Int>> {
        val m = grid.size
        val n = grid[0].size.toLong()
        var k = k

        val seen = mutableSetOf<Long>()
        var queue = setOf(start.toList())
        seen.add(start[0] * n + start[1])

        val rst = mutableListOf<List<Int>>()
        if (grid[start[0]][start[1]] in pricing[0]..pricing[1]) {
            rst.add(start.toList())
            k--
        }

        while (k > 0 && queue.isNotEmpty()) {
            val next = mutableSetOf<List<Int>>()
            val available = PriorityQueue(compareByDescending<List<Int>> { grid[it[0]][it[1]] }.thenByDescending{ it[0] }.thenByDescending{ it[1] })

            for ((i, j) in queue) {
                for ((dx, dy) in listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)) {
                    val x = i + dx
                    val y = j + dy
                    if (x in 0 until m && y in 0 until n && x * n + y !in seen && grid[x][y] != 0) {
                        seen.add(x * n + y)
                        next.add(listOf(x, y))
                        if (grid[x][y] in pricing[0]..pricing[1]) {
                            available.offer(listOf(x, y))
                            if (available.size > k)
                                available.poll()
                        }
                    }
                }
            }

            k -= available.size
            val reverse = mutableListOf<List<Int>>()
            while (available.isNotEmpty())
                reverse.add(available.poll())
            rst.addAll(reverse.reversed())

            queue = next
        }

        return rst
    }
}
