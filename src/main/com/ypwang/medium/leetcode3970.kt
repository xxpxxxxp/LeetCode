package com.ypwang.medium

import java.util.PriorityQueue

class Solution3970 {
    fun shortestPath(n: Int, edges: Array<IntArray>, labels: String, k: Int): Int {
        val INF = Long.MAX_VALUE / 4

        val adj = Array(n) { mutableListOf<IntArray>() }
        for ((a, b, c) in edges)
            adj[a].add(intArrayOf(b, c))

        val dist = Array(n) { LongArray(k + 1) { INF } }

        // {distance, node, cnt}
        val pq =
            PriorityQueue<LongArray>(compareBy { it[0] })

        dist[0][1] = 0
        pq.offer(longArrayOf(0, 0, 1))

        while (pq.isNotEmpty()) {
            val cur = pq.poll()
            val d = cur[0]
            val u = cur[1].toInt()
            val run = cur[2].toInt()

            if (d != dist[u][run])
                continue

            for ((v, w) in adj[u]) {
                val newRun = if (labels[v] == labels[u]) run + 1 else 1
                if (newRun > k)
                    continue

                if (dist[v][newRun] > d + w) {
                    dist[v][newRun] = d + w
                    pq.offer(longArrayOf(dist[v][newRun], v.toLong(), newRun.toLong()))
                }
            }
        }

        var ans = INF
        for (i in 1..k)
            ans = minOf(ans, dist[n - 1][i])
        return if (ans == INF) -1 else ans.toInt()
    }
}
