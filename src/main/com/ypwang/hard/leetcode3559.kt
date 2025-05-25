package com.ypwang.hard

import kotlin.math.ceil
import kotlin.math.ln

class Solution3559 {
    val MOD = 1000000007

    fun assignEdgeWeights(edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val nodes = edges.size + 1

        val tree = Array(nodes + 1) { mutableListOf<Int>() }
        for ((a, b) in edges) {
            tree[a].add(b)
            tree[b].add(a)
        }

        val maxLog = ceil(ln(nodes.toDouble()) / ln(2.0)).toInt() + 1
        val lifting = Array(nodes + 1) { IntArray(maxLog) }
        val dist = IntArray(nodes + 1)
        val startTime = IntArray(nodes + 1)
        val endTime = IntArray(nodes + 1)

        var time = 0
        fun dfsLCA(node: Int, parent: Int, depth: Int) {
            dist[node] = depth
            startTime[node] = time++
            lifting[node][0] = parent

            for (i in 1 until lifting[0].size)
                lifting[node][i] = lifting[lifting[node][i - 1]][i - 1]

            for (child in tree[node])
                if (child != parent)
                    dfsLCA(child, node, depth + 1)

            endTime[node] = time++
        }

        dfsLCA(1, 1, 0)

        val dp = Array(2) { IntArray(nodes + 1) { -1 } }

        fun dfsWeightWays(remaining: Int, currentSum: Int): Int {
            if (remaining == 0)
                return if (currentSum % 2 == 1) 1 else 0

            if (dp[currentSum % 2][remaining] == -1) {
                val waysWith1 = dfsWeightWays(remaining - 1, currentSum + 1).toLong()
                val waysWith2 = dfsWeightWays(remaining - 1, currentSum + 2).toLong()
                dp[currentSum % 2][remaining] = ((waysWith1 + waysWith2) % MOD).toInt()
            }

            return dp[currentSum % 2][remaining]
        }

        fun isAncestor(u: Int, v: Int): Boolean =
            startTime[u] <= startTime[v] && endTime[u] >= endTime[v]

        fun getLCA(u: Int, v: Int): Int {
            var u = u
            if (isAncestor(u, v))
                return u
            if (isAncestor(v, u))
                return v

            for (i in lifting[0].indices.reversed())
                if (!isAncestor(lifting[u][i], v))
                    u = lifting[u][i]

            return lifting[u][0]
        }

        val result = IntArray(queries.size)
        for (i in queries.indices) {
            val (u, v) = queries[i]
            val pathLength = dist[u] + dist[v] - 2 * dist[getLCA(u, v)]
            result[i] = dfsWeightWays(pathLength, 0)
        }
        return result
    }
}
