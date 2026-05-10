package com.ypwang.hard

import java.util.*

class Solution3928 {
    val INF: Long = Long.MAX_VALUE / 4

    class Edge(var to: Int, var w: Long)

    class Node(var u: Int, var d: Long): Comparable<Node> {
        override fun compareTo(other: Node): Int =
            this.d.compareTo(other.d)
    }

    fun dijkstra(g: Array<MutableList<Edge>>, s: Int): LongArray {
        val n = g.size
        val d = LongArray(n) { INF }
        d[s] = 0

        val pq = PriorityQueue<Node>()
        pq.offer(Node(s, 0))

        while (pq.isNotEmpty()) {
            val cur = pq.poll()
            val u = cur.u

            if (cur.d != d[u])
                continue

            for (e in g[u]) {
                val v = e.to
                val nd = d[u] + e.w

                if (nd < d[v]) {
                    d[v] = nd
                    pq.offer(Node(v, nd))
                }
            }
        }

        return d
    }

    fun minCost(n: Int, prices: IntArray, roads: Array<IntArray>): IntArray {
        val empty = Array(n) { mutableListOf<Edge>() }
        val carry = Array(n) { mutableListOf<Edge>() }

        for ((u, v, c, t) in roads) {
            empty[u].add(Edge(v, c.toLong()))
            empty[v].add(Edge(u, c.toLong()))

            carry[u].add(Edge(v, c.toLong() * t))
            carry[v].add(Edge(u, c.toLong() * t))
        }

        val de = Array(n) { dijkstra(empty, it) }
        val dc = Array(n) { dijkstra(carry, it) }

        val res = IntArray(n)

        for (i in 0 until n) {
            var best = prices[i].toLong()
            for (j in 0 until n) {
                if (de[i][j] == INF || dc[j][i] == INF)
                    continue

                val curr = de[i][j] + dc[j][i] + prices[j]

                if (curr < best)
                    best = curr
            }

            res[i] = best.toInt()
        }

        return res
    }
}
