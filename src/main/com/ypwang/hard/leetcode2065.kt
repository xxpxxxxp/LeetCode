package com.ypwang.hard

class Solution2065 {
    fun maximalPathQuality(values: IntArray, edges: Array<IntArray>, maxTime: Int): Int {
        val relations = Array(values.size) { mutableListOf<Pair<Int, Int>>() }

        for ((u, v, time) in edges) {
            relations[u].add(v to time)
            relations[v].add(u to time)
        }

        var rst = 0
        val visited = IntArray(values.size)

        fun dfs(idx: Int, left: Int, score: Int) {
            visited[idx]++

            var next = score
            if (visited[idx] == 1)
                next += values[idx]

            if (idx == 0)
                rst = maxOf(rst, next)

            for ((j, t) in relations[idx])
                if (left - t >= 0)
                    dfs(j, left - t, next)

            visited[idx]--
        }

        dfs(0, maxTime, 0)
        return rst
    }
}