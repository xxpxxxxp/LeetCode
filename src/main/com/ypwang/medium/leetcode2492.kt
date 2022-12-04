package com.ypwang.medium

class Solution2492 {
    fun minScore(n: Int, roads: Array<IntArray>): Int {
        val dsu = IntArray(n + 1) { it }
        val ans = IntArray(n + 1) { Int.MAX_VALUE }

        fun root(i: Int): Int {
            if (dsu[i] != i)
                dsu[i] = root(dsu[i])
            return dsu[i]
        }

        for ((a, b, road) in roads) {
            val ra = root(a)
            val rb = root(b)
            dsu[ra] = dsu[rb]
            ans[rb] = minOf(road, minOf(ans[ra], ans[rb]))
            ans[ra] = ans[rb]
        }
        return ans[root(1)]
    }
}