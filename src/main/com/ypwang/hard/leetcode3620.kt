package com.ypwang.hard

import java.util.*

class Solution3620 {
    private fun dijkstra(src: Int, target: Int, adj: Array<MutableList<IntArray>>, n: Int): Long {
        val dist = LongArray(n) { Long.MAX_VALUE / 4 }
        dist[src] = 0
        val pq =
            PriorityQueue<LongArray>(compareBy { it[0] })
        pq.offer(longArrayOf(0, src.toLong()))

        while (pq.isNotEmpty()) {
            val (d, x) = pq.poll()
            val u = x.toInt()
            if (d > dist[u])
                continue
            if (u == target)
                return d

            for ((v, w) in adj[u]) {
                if (dist[v] > d + w) {
                    dist[v] = d + w
                    pq.offer(longArrayOf(dist[v], v.toLong()))
                }
            }
        }

        return Long.MAX_VALUE / 4
    }

    fun findMaxPathScore(edges: Array<IntArray>, online: BooleanArray, k: Long): Int {
        val n = online.size
        var l = 0L
        var h = 1e9.toLong()
        var best = -1L

        while (l <= h) {
            val mid = (l + h) / 2
            val adj = Array(n) { mutableListOf<IntArray>() }

            for ((u, v, c) in edges)
                if (c >= mid && online[u] && online[v])
                    adj[u].add(intArrayOf(v, c))

            val dist = dijkstra(0, n - 1, adj, n)
            if (dist <= k) {
                best = mid
                l = mid + 1
            } else
                h = mid - 1
        }
        return best.toInt()
    }
}
