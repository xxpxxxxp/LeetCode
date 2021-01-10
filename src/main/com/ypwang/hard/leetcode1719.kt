package com.ypwang.hard

import java.util.*

class Solution1719 {
    fun checkWays(pairs: Array<IntArray>): Int {
        val adj = mutableMapOf<Int, MutableSet<Int>>()

        for ((i, j) in pairs) {
            adj.getOrPut(i, { mutableSetOf() }).add(j)
            adj.getOrPut(j, { mutableSetOf() }).add(i)
        }

        val heap = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.second })
        for ((i, s) in adj)
            heap.offer(i to s.size)

        val totalNodes = heap.size
        var rst = 1

        while (heap.isNotEmpty()) {
            val (node, degree) = heap.poll()

            var parent = -1
            var parentDegree = Int.MAX_VALUE
            for (neighbour in adj[node]!!) {
                if (adj[neighbour]!!.size in degree until parentDegree) {
                    parent = neighbour
                    parentDegree = adj[neighbour]!!.size
                }
            }

            if (parent == -1) {
                if (degree != totalNodes-1)
                    return 0

                continue
            }

            for (neighbour in adj[node]!!) {
                if (neighbour == parent)
                    continue

                if (neighbour !in adj[parent]!!)
                    return 0
            }

            if (degree == parentDegree)
                rst = 2
        }

        return rst
    }
}