package com.ypwang.hard

import java.util.*

class Solution2050 {
    fun minimumTime(n: Int, relations: Array<IntArray>, time: IntArray): Int {
        val degree = IntArray(n)
        val graph = mutableMapOf<Int, MutableList<Int>>()
        for ((prev, next) in relations) {
            graph.getOrPut(prev-1) { mutableListOf() }.add(next-1)
            degree[next-1]++
        }

        val dist = IntArray(n)
        val q: Queue<Int> = LinkedList()

        for ((i, v) in degree.withIndex()) {
            if (v == 0) {
                q.add(i)
                dist[i] = time[i]
            }
        }

        while (q.isNotEmpty()) {
            val next = q.poll()
            for (v in graph.getOrDefault(next, mutableListOf())) {
                dist[v] = maxOf(dist[v], dist[next] + time[v])
                if (--degree[v] == 0)
                    q.add(v)
            }
        }

        return dist.maxOrNull()!!
    }
}
