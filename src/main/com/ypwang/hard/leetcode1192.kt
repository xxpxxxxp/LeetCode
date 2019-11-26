package com.ypwang.hard

class Solution1192 {
    fun criticalConnections(n: Int, connections: List<List<Int>>): List<List<Int>> {
        val dfn = IntArray(n){-1}
        val low = IntArray(n)
        val parent = IntArray(n){-1}

        val graph = Array<MutableList<Int>?>(n){ null }

        val rst = mutableListOf<List<Int>>()
        for ((a, b) in connections) {
            if (graph[a] == null) graph[a] = mutableListOf()
            graph[a]!!.add(b)
            if (graph[b] == null) graph[b] = mutableListOf()
            graph[b]!!.add(a)
        }

        var cnt = 0
        fun dfs(idx: Int) {
            ++cnt
            dfn[idx] = cnt
            low[idx] = cnt
            if (graph[idx] != null) {
                for (v in graph[idx]!!) {
                    if (dfn[v] == -1) {
                        parent[v] = idx
                        dfs(v)
                        low[idx] = minOf(low[idx], low[v])
                        if (low[v] > dfn[idx]) {
                            rst.add(listOf(idx, v))
                        }
                    } else if (v != parent[idx]) {
                        low[idx] = minOf(low[idx], dfn[v])
                    }
                }
            }
        }

        for (i in 0 until n) {
            if (dfn[i] == -1) {
                parent[i] = i
                dfs(i)
            }
        }

        return rst
    }
}