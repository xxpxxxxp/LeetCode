package com.ypwang.medium

class Solution3372 {
    fun dfs(i: Int, p: Int, al: Array<MutableList<Int>>, k: Int): Int {
        if (k <= 0)
            return if (k == 0) 1 else 0
        var res = 1
        for (j in al[i])
            if (j != p)
                res += dfs(j, i, al, k - 1)
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

    fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>, k: Int): IntArray {
        val m = edges1.size + 1
        val n = edges2.size + 1
        var max2 = 0

        for (i in 0 until n)
            max2 = maxOf(max2, dfs(i, -1, adjacencyList(edges2), k - 1))

        val res = IntArray(m)
        for (i in 0 until m)
            res[i] = max2 + dfs(i, -1, adjacencyList(edges1), k)

        return res
    }
}
