package com.ypwang.hard

class Solution2421 {
    fun numberOfGoodPaths(vals: IntArray, edges: Array<IntArray>): Int {
        // create adjacency list
        val adjList = Array(vals.size) { mutableListOf<Int>() }

        // create sortedmap with key as node value and value as list of index
        val tm = mutableMapOf<Int, MutableList<Int>>()

        // create unionfind
        val uf = UnionFind(vals.size)
        for ((i, v) in vals.withIndex())
            tm.getOrPut(v) { mutableListOf() }.add(i)

        for ((a, b) in edges) {
            adjList[a].add(b)
            adjList[b].add(a)
        }

        var sum = vals.size
        for ((_, idx) in tm.toList().sortedBy { it.first }) {
            // for each node union with neighbor if neighbor value is
            // lower or equal to node value
            for (node in idx) {
                for (neighbor in adjList[node]) {
                    if (vals[node] >= vals[neighbor]) {
                        uf.merge(node, neighbor)
                    }
                }
            }

            // check if each node is in union with other node with
            // same value
            if (idx.isNotEmpty()) {
                val freq = mutableMapOf<Int, Int>()

                // create frequency map of parent, to count number of nodes of same value in each set
                for (v in idx) {
                    val parent = uf.find(v)
                    freq[parent] = freq.getOrDefault(parent, 0) + 1
                }

                // apply arithmetic progression formula to find sum of good paths
                for (v in freq.values)
                    sum += v * (v - 1) / 2
            }
        }
        return sum
    }

    class UnionFind(n: Int) {
        private val dp = IntArray(n) { it }
        private val rank = IntArray(n) { 1 }

        fun find(i: Int): Int {
            if (dp[i] != i)
                dp[i] = find(dp[i])
            return dp[i]
        }

        fun merge(x: Int, y: Int) {
            if (find(x) == find(y))
                return

            val xp = find(x)
            val yp = find(y)
            if (rank[xp] < rank[yp]) {
                dp[xp] = yp
            } else {
                dp[yp] = dp[xp]
                if (rank[xp] == rank[yp]) {
                    rank[xp]++
                }
            }
        }
    }
}