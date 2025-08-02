package com.ypwang.medium

import java.util.*

class Solution3604 {
    fun minTime(n: Int, edges: Array<IntArray>): Int {
        val dp = IntArray(n) { Int.MAX_VALUE }

        val h = PriorityQueue<IntArray>(compareBy { it[0] })
        h.add(intArrayOf(0, 0))
        val conn = Array(n) { mutableListOf<IntArray>() }
        for ((a, b, c, d) in edges)
            conn[a].add(intArrayOf(b, c, d))

        while (h.isNotEmpty()) {
            val (t, u) = h.poll()
            if (u == n - 1)
                return t

            if (t >= dp[u])
                continue

            dp[u] = t
            for (edge in conn[u]) {
                val (v, s, e) = edge
                if (t <= e) {
                    val t2 = maxOf(s, t) + 1
                    if (t2 < dp[v])
                        h.add(intArrayOf(t2, v))
                }
            }
        }
        return -1
    }
}
