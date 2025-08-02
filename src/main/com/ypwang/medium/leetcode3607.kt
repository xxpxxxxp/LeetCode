package com.ypwang.medium

import java.util.*

class Solution3607 {
    class DSU(n: Int) {
        val parent = IntArray(n + 1) { it }

        fun find(x: Int): Int {
            if (parent[x] != x)
                parent[x] = find(parent[x])

            return parent[x]
        }

        fun union(x: Int, y: Int): Boolean {
            val px = find(x)
            val py = find(y)
            if (px == py)
                return false
            parent[py] = px
            return true
        }
    }

    fun processQueries(c: Int, connections: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val dsu = DSU(c)
        val online = BooleanArray(c + 1) { true }

        for (conn in connections)
            dsu.union(conn[0], conn[1])

        val componentHeap = mutableMapOf<Int, PriorityQueue<Int>>()
        for (station in 1..c) {
            val root = dsu.find(station)
            componentHeap.getOrPut(root, { PriorityQueue<Int>() }).offer(station)
        }

        val result = mutableListOf<Int>()

        for ((type, x) in queries) {
            if (type == 2)
                online[x] = false
            else {
                if (online[x]) {
                    result.add(x)
                } else {
                    val heap = componentHeap[dsu.find(x)]!!

                    while (heap.isNotEmpty() && !online[heap.peek()])
                        heap.poll()

                    result.add(if (heap.isEmpty()) -1 else heap.peek())
                }
            }
        }

        return result.toIntArray()
    }
}
