package com.ypwang.hard

import java.util.PriorityQueue

class Solution3977 {
    fun minTimeMaxPower(n: Int, edges: Array<IntArray>, power: Int, cost: IntArray, source: Int, target: Int): LongArray {
        val inf = 1e18.toLong()
        val adj = Array(n) { mutableListOf<IntArray>() }
        for ((u, v, w) in edges)
            adj[u].add(intArrayOf(v, w))

        val dist = Array(n) { LongArray(power + 1) { inf } }
        dist[source][power] = 0

        // priority queue stores {time, node, remaining power}
        val pq = PriorityQueue<LongArray>(compareBy { it[0] })
        pq.offer(longArrayOf(0, source.toLong(), power.toLong()))
        var best = -1L
        var bestp = -1L

        while (pq.isNotEmpty()) {
            val vec = pq.poll()
            val time = vec[0]
            val u = vec[1].toInt()
            val remp = vec[2].toInt()

            if (time != dist[u][remp])
                continue
            if (best != -1L && time > best)
                break
            if (u == target) {
                if (best == -1L) best = time
                bestp = maxOf(remp.toLong(), bestp)
                continue
            }
            if (remp < cost[u])
                continue

            val nxtp = remp - cost[u]
            for ((v, w) in adj[u]) {
                val ntime = time + w
                if (ntime < dist[v][nxtp]) {
                    dist[v][nxtp] = ntime
                    pq.offer(longArrayOf(ntime, v.toLong(), nxtp.toLong()))
                }
            }
        }

        return longArrayOf(best, bestp)
    }
}
