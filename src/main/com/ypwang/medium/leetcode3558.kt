package com.ypwang.medium

class Solution3558 {
    private val MOD = 1000000007

    private fun power(base: Long, exp: Long): Long {
        var base = base
        var exp = exp
        var res: Long = 1
        base %= MOD.toLong()
        while (exp > 0) {
            if (exp % 2 == 1L) res = (res * base) % MOD
            base = (base * base) % MOD
            exp /= 2
        }
        return res
    }

    private fun modularInverse(n: Long): Long {
        if (n == 2L)
            return (MOD + 1L) / 2
        return power(n, (MOD - 2).toLong())
    }

    private fun dfs(currentNode: Int, parentNode: Int, adjList: Map<Int, MutableList<Int>>): Int {
        var maxSubtreeDepth = 0
        for (neighbor in adjList.getOrDefault(currentNode, emptyList())) {
            if (neighbor == parentNode)
                continue
            maxSubtreeDepth = maxOf(maxSubtreeDepth, dfs(neighbor, currentNode, adjList) + 1)
        }
        return maxSubtreeDepth
    }

    fun assignEdgeWeights(edges: Array<IntArray>): Int {
        val adjList = mutableMapOf<Int, MutableList<Int>>()

        for ((u, v) in edges) {
            adjList.getOrPut(u) { mutableListOf() }.add(v)
            adjList.getOrPut(v) { mutableListOf() }.add(u)
        }

        val maxDepthVal = dfs(1, 0, adjList)
        if (maxDepthVal == 0)
            return modularInverse(2).toInt()
        else {
            val exponent = (maxDepthVal - 1).toLong()
            return power(2, exponent).toInt()
        }
    }
}
