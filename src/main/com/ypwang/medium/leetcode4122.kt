package com.ypwang.medium

import java.util.*

class Solution4122 {
    fun earliestActivationTimes(n: Int, edges: Array<IntArray>, requiredSignals: IntArray): LongArray {
        val g = Array(n) { mutableListOf<IntArray>() }
        for ((a, b, c) in edges) {
            g[a].add(intArrayOf(c, b))
        }

        val q = PriorityQueue<LongArray>(compareBy { it[0] })
        for ((x, y) in g[0])
            q.offer(longArrayOf(x.toLong(), y.toLong()))

        val res = LongArray(n) { -1 }
        res[0] = 0

        while (q.isNotEmpty()) {
            val (t, v) = q.poll()!!
            val u = v.toInt()
            if (res[u] >= 0)
                continue

            if (--requiredSignals[u] == 0) {
                res[u] = t
                for ((x, y) in g[u])
                    if (res[y] < 0)
                        q.offer(longArrayOf(t + x, y.toLong()))
            }
        }
        return res
    }
}
