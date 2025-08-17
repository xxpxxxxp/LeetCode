package com.ypwang.medium

import java.util.PriorityQueue

class Solution3650 {
    fun minCost(n: Int, edges: Array<IntArray>): Int {
        val graph = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for ((from, to, cost) in edges) {
            graph[from].add(to to cost)
            graph[to].add(from to cost * 2)
        }
        val INF = Int.MAX_VALUE / 2
        val d = IntArray(n) { INF }
        d[0] = 0
        val q = PriorityQueue(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
        q.offer(0 to 0)

        while (q.isNotEmpty()) {
            val (distance, from) = q.poll()
            if (distance > d[from]) continue
            for ((to, cost) in graph[from]) {
                if (d[to] > d[from] + cost) {
                    d[to] = d[from] + cost
                    q.offer(d[to] to to)
                }
            }
        }

        return d[n - 1].let { if (it == INF) -1 else it }
    }
}
