package com.ypwang.hard

import java.util.*

class Graph(val n: Int, edges: Array<IntArray>) {
    private val conn = Array(n) { mutableMapOf<Int, Int>() }

    init {
        for ((a, b, c) in edges)
            conn[a][b] = c
    }

    fun addEdge(edge: IntArray) {
        val (a, b, c) = edge
        conn[a][b] = c
    }

    fun shortestPath(node1: Int, node2: Int): Int {
        val dist = IntArray(n) { Int.MAX_VALUE }
        dist[node1] = 0
        val heap = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        heap.add(0 to node1)

        while (heap.isNotEmpty()) {
            val (dis, node) = heap.poll()
            if (node == node2)
                return dis

            if (dis > dist[node])
                continue

            for ((next, cost) in conn.getOrElse(node) { mutableMapOf() }) {
                val nextDis = dis + cost
                if (nextDis < dist[next]) {
                    dist[next] = nextDis
                    heap.add(nextDis to next)
                }
            }
        }

        return -1
    }
}