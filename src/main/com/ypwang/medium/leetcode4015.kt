package com.ypwang.medium

class Solution4015 {
    // DFS to calculate depth of every node
    fun depth(depth: LongArray, tree: MutableMap<Int, MutableList<Int>>, node: Int) {
        if (node !in tree)
            return

        for (child in tree[node]!!) {
            depth[child] = depth[node] + 1
            depth(depth, tree, child)
        }
    }

    fun weightedSum(parent: IntArray, nums: IntArray): Long {
        val tree = mutableMapOf<Int, MutableList<Int>>()

        // Build adjacency list from the parent array
        for (i in 1 until parent.size)
            tree.computeIfAbsent(parent[i]) { mutableListOf() }.add(i)

        // Calculate depth of every node
        val depth = LongArray(parent.size)

        // Root is at depth 1
        depth[0] = 1
        depth(depth, tree, 0)

        // Find the maximum depth of the tree
        var height = 0L

        for (d in depth)
            height = maxOf(height, d)

        // Calculate weighted sum
        var ans = 0L

        for (i in nums.indices)
            ans += (height - depth[i] + 1) * nums[i]

        return ans
    }
}
