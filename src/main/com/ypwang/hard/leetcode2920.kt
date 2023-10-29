package com.ypwang.hard

class Solution2920 {
    fun maximumPoints(edges: Array<IntArray>, coins: IntArray, k: Int): Int {
        val n = edges.size + 1
        val conn = Array(n) { mutableListOf<Int>() }
        for ((a, b) in edges) {
            conn[a].add(b)
            conn[b].add(a)
        }

        val vis = Array(100001) { BooleanArray(14) }
        fun dfs(i: Int, p: Int, A: IntArray, k: Int, v: Int): Int {
            if (v > 13)
                return 0
            if (vis[i][v])
                return 0

            vis[i][v] = true
            var op1 = (A[i] shr v) - k
            var op2 = A[i] shr v + 1
            for (j in conn[i]) {
                if (j == p)
                    continue
                op1 += dfs(j, i, A, k, v)
                op2 += dfs(j, i, A, k, v + 1)
            }
            return maxOf(op1, op2)
        }

        return dfs(0, -1, coins, k, 0)
    }
}