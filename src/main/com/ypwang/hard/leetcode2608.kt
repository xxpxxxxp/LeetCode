package com.ypwang.hard

import java.util.*

class Solution2608 {
    fun findShortestCycle(n: Int, edges: Array<IntArray>): Int {
        val conn = Array(n) { mutableListOf<Int>() }
        for ((a, b) in edges) {
            conn[a].add(b)
            conn[b].add(a)
        }

        var res = Int.MAX_VALUE
        fun bfs(i: Int): Int {
            val dis = IntArray(n) { Int.MAX_VALUE }
            val fa = IntArray(n) { -1 }
            dis[i] = 0
            val queue: Queue<Int> = LinkedList()
            queue.offer(i)
            while (queue.isNotEmpty()) {
                val j = queue.poll()
                for (next in conn[j]) {
                    if (dis[next] == Int.MAX_VALUE) {
                        dis[next] = dis[j] + 1
                        fa[next] = j
                        queue.offer(next)
                    } else if (fa[j] != next && fa[next] != j) {
                        return dis[j] + dis[next] + 1
                    }
                }
            }
            return Int.MAX_VALUE
        }

        for (i in 0 until n)
            res = minOf(res, bfs(i))
        return if (res < Int.MAX_VALUE) res else -1
    }
}