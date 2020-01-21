package com.ypwang.hard

import java.util.*

class Solution913 {
    fun catMouseGame(graph: Array<IntArray>): Int {
        val N = graph.size
        val color = Array(50){ Array(50) { IntArray(3) } }
        val degree = Array(50){ Array(50) { IntArray(3) } }

        // t -> 1: MOUSE MOVE, 2: CAT MOVE
        // c -> 0: DRAW, 1: MOUSE WIN, 2: CAT WIN
        for (m in 0 until N) {
            for (c in 0 until N) {
                degree[m][c][1] = graph[m].size
                degree[m][c][2] = graph[c].count { it != 0 }
            }
        }

        val queue: Queue<IntArray> = LinkedList()
        for (i in 0 until N) {
            for (t in 1..2) {
                color[0][i][t] = 1
                queue.add(intArrayOf(0, i, t, 1))
                if (i > 0) {
                    color[i][i][t] = 2
                    queue.add(intArrayOf(i, i, t, 2))
                }
            }
        }

        fun parents(m: Int, c: Int, t: Int): List<IntArray> =
            when (t) {
                1 -> graph[c].filter { it != 0 }.map { intArrayOf(m, it, 3-t) } // previous is cat move
                2 -> graph[m].map { intArrayOf(it, c, 3-t) } // previous is mose move
                else -> listOf()
            }

        while (queue.isNotEmpty()) {
            val (i, j, t, c) = queue.poll()
            for ((i2, j2, t2) in parents(i, j, t)) {
                if (color[i2][j2][t2] == 0) {
                    if (t2 == c) {
                        color[i2][j2][t2] = c
                        queue.add(intArrayOf(i2, j2, t2, c))
                    } else {
                        if (--degree[i2][j2][t2] == 0) {
                            color[i2][j2][t2] = 3 - t2
                            queue.add(intArrayOf(i2, j2, t2, 3-t2))
                        }
                    }
                }
            }
        }

        return color[1][2][1]
    }
}