package com.ypwang.hard

class Solution3910 {
    fun dfs(u: Int, adj: Array<MutableList<Int>>, vis: IntArray) {
        if (vis[u] == 1)
            return
        vis[u] = 1
        for (v in adj[u])
            if (vis[v] == 0)
                dfs(v, adj, vis)
    }

    fun evenSumSubgraphs(nums: IntArray, edges: Array<IntArray>): Int {
        val n = nums.size
        val adj = Array(n) { mutableListOf<Int>() }

        // Build adjacency list
        for ((a, b) in edges) {
            adj[a].add(b)
            adj[b].add(a)
        }

        val vis = IntArray(n)
        var ans = 0

        for (mask in 1 until (1 shl n)) {
            // Reset vis array to -1
            vis.fill(-1)

            val subset = mutableListOf<Int>()
            var sum = 0

            // Build subset
            for (j in 0 until n) {
                if ((mask and (1 shl j)) != 0) {
                    subset.add(j)
                    vis[j] = 0
                    sum += nums[j]
                }
            }

            // Run DFS from first node in subset
            dfs(subset[0], adj, vis)

            // Count visited nodes
            if (vis.count { it == 1 } == subset.size && sum % 2 == 0)
                ans++
        }

        return ans
    }
}

fun main() {
    println(Solution3910().evenSumSubgraphs(
        intArrayOf(1,0,1), arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
    ))
}