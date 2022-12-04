package com.ypwang.hard

import java.util.*

class Solution2493 {
    fun magnificentSets(n: Int, edges: Array<IntArray>): Int {
        val dsu = IntArray(n + 1) { it }
        fun root(i: Int): Int {
            if (dsu[i] != i)
                dsu[i] = root(dsu[i])
            return dsu[i]
        }

        val adj = Array(n + 1) { mutableListOf<Int>() }
        for ((a, b) in edges) {
            adj[a].add(b)
            adj[b].add(a)
            dsu[root(a)] = root(b)
        }

        fun bfs(i: Int): Int {
            var pre = setOf<Int>()
            var cur = setOf(i)

            val vis = BooleanArray(n + 1)
            vis[i] = true
            var c = 0
            while (cur.isNotEmpty()) {
                c++
                val next = mutableSetOf<Int>()
                for (a in cur) {
                    for (b in adj[a]) {
                        if (b !in pre && b !in next) {
                            if (vis[b])
                                return -1
                            vis[b] = true
                            next.add(b)
                        }
                    }
                }
                pre = cur
                cur = next
            }
            return c
        }

        val dp = IntArray(n + 1) { -1 }
        val map = mutableMapOf<Int, Int>()
        for (i in 1..n) {
            val ri = root(i)
            dp[ri] = maxOf(dp[ri], bfs(i))
            map[ri] = dp[ri]
        }
        if (map.values.any { it == -1 })
            return -1
        return map.values.sum()
    }
}