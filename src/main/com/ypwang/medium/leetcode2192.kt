package com.ypwang.medium

class Solution2192 {
    fun getAncestors(n: Int, edges: Array<IntArray>): List<List<Int>> {
        val rst = Array(n) { mutableListOf<Int>() }
        val directChild = Array(n) { mutableListOf<Int>() }

        for ((a, b) in edges)
            directChild[a].add(b)

        fun dfs(from: Int, cur: Int) {
            for (node in directChild[cur]) {
                if (rst[node].isEmpty() || rst[node].last() != from) {
                    rst[node].add(from)
                    dfs(from, node)
                }
            }
        }

        for (i in 0 until n)
            dfs(i, i)

        return rst.toList()
    }
}