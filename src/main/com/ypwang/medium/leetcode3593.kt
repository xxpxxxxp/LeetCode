package com.ypwang.medium

class Solution3593 {
    fun minIncrease(n: Int, edges: Array<IntArray>, cost: IntArray): Int {
        val G = Array(n) { mutableListOf<Int>() }
        for ((u, v) in edges) {
            G[u].add(v)
            G[v].add(u)
        }

        var res = 0
        fun dfs(i: Int, f: Int): Int {
            val score = mutableListOf<Int>()
            for (j in G[i]) {
                if (j == f)
                    continue
                score.add(dfs(j, i))
            }
            if (score.isEmpty())
                return cost[i]

            val max = score.max()
            res += score.count { it != max }
            return max + cost[i]
        }

        dfs(0, -1)
        return res
    }
}
