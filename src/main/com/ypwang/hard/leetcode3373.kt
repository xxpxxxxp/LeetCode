package com.ypwang.hard

class Solution3373 {
    private val parity = BooleanArray(100001)

    private fun dfs(i: Int, p: Int, al: Array<MutableList<Int>>, even: Boolean): Int {
        var res = if (even) 1 else 0
        parity[i] = even
        for (j in al[i])
            if (j != p)
                res += dfs(j, i, al, !even)
        return res
    }

    fun adjacencyList(edges: Array<IntArray>): Array<MutableList<Int>> {
        val al = Array(edges.size + 1) { mutableListOf<Int>() }
        for ((x, y) in edges) {
            al[x].add(y)
            al[y].add(x)
        }
        return al
    }

    // Main function to calculate the max target nodes
    fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>): IntArray {
        val m = edges1.size + 1
        val n = edges2.size + 1

        val even2 = dfs(0, -1, adjacencyList(edges2), true)
        val even1 = dfs(0, -1, adjacencyList(edges1), true)

        val res = IntArray(m)
        for (i in 0 until m)
            res[i] = maxOf(even2, n - even2) + if (parity[i]) even1 else m - even1

        return res
    }
}
