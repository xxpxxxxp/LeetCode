package com.ypwang.medium

import java.util.*

class Solution2818 {
    fun maximumSafenessFactor(grid: List<List<Int>>): Int {
        val size = grid.size
        val g = Array(size) { IntArray(size) }
        val queue: Queue<Pair<Int, Int>> = LinkedList()


        for ((i, ls) in grid.withIndex()) {
            for ((j, v) in ls.withIndex()) {
                g[i][j] = v
                if (v == 1)
                    queue.add(i to j)
            }
        }

        val d = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
        while (queue.isNotEmpty()) {
            val (x, y) = queue.poll()
            for ((dx, dy) in d) {
                val nx = x + dx
                val ny = y + dy
                if (nx in 0 until size && ny in 0 until size && (g[nx][ny] == 0 || g[nx][ny] > g[x][y] + 1)) {
                    g[nx][ny] = g[x][y] + 1
                    queue.add(nx to ny)
                }
            }
        }

        // distance, x, y
        val heap = PriorityQueue<Triple<Int, Int, Int>>(compareByDescending { it.first })
        heap.add(Triple(g[0][0], 0, 0))
        g[0][0] = -1
        while (heap.isNotEmpty()) {
            val (dis, x, y) = heap.poll()
            if (x == size - 1 && y == size - 1)
                return dis - 1

            for ((dx, dy) in d) {
                val nx = x + dx
                val ny = y + dy
                if (nx in 0 until size && ny in 0 until size && g[nx][ny] != -1) {
                    heap.offer(Triple(minOf(dis, g[nx][ny]), nx, ny))
                    g[nx][ny] = -1
                }
            }
        }

        return 0
    }
}

fun main() {
    println(Solution2818().maximumSafenessFactor(listOf(
        listOf(0,0,1), listOf(0,0,0), listOf(0,0,0)
    )))
}