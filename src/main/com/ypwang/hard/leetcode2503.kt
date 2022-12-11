package com.ypwang.hard

import java.util.*

class Solution2503 {
    private val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))

    fun maxPoints(grid: Array<IntArray>, queries: IntArray): IntArray {
        val m = grid.size
        val n = grid[0].size
        val map = TreeMap<Int, Int>()
        val res = IntArray(queries.size)
        val prefix = TreeMap<Int, Int>()

        fun bfs() {
            var max = 0
            val queue = PriorityQueue<IntArray>(compareBy { it[0] })
            val visited = Array(m) { BooleanArray(n) }
            queue.offer(intArrayOf(grid[0][0], 0, 0))
            visited[0][0] = true
            while (queue.isNotEmpty()) {
                val (v, x, y) = queue.poll()
                max = maxOf(v, max)
                map[max] = map.getOrDefault(max, 0) + 1
                for ((dx, dy) in dirs) {
                    val neiX = x + dx
                    val neiY = y + dy
                    if (neiX in 0 until m && neiY in 0 until n && !visited[neiX][neiY]) {
                        visited[neiX][neiY] = true
                        queue.offer(intArrayOf(grid[neiX][neiY], neiX, neiY))
                    }
                }
            }
        }

        bfs()
        var prev = 0
        for ((k, v) in map) {
            prev += v
            prefix[k] = prev
        }
        for ((i, v) in queries.withIndex()) {
            val cur = prefix.lowerKey(v)
            res[i] =
                if (cur != null)
                    prefix[cur]!!
                else
                    0
        }
        return res
    }
}