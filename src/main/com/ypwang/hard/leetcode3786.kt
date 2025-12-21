package com.ypwang.hard

class Solution3786 {
    fun interactionCosts(n: Int, edges: Array<IntArray>, group: IntArray): Long {
        var totalCost = 0L
        val counts = Array(n) { IntArray(21) }
        val totalInGroup = IntArray(21)
        val adj = Array(n) { mutableListOf<Int>() }

        for ((a, b) in edges) {
            adj[a].add(b)
            adj[b].add(a)
        }

        for (g in group)
            totalInGroup[g]++

        fun dfs(u: Int, p: Int, group: IntArray) {
            counts[u][group[u]] = 1

            for (v in adj[u]) {
                if (v == p)
                    continue

                dfs(v, u, group)

                for (g in 1..20) {
                    if (totalInGroup[g] < 2)
                        continue

                    val inSubtree = counts[v][g].toLong()
                    val outsideSubtree = totalInGroup[g] - inSubtree

                    totalCost += inSubtree * outsideSubtree
                    counts[u][g] += counts[v][g]
                }
            }
        }

        dfs(0, -1, group)
        return totalCost
    }
}
