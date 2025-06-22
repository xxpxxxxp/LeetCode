package com.ypwang.hard

import java.util.TreeSet

class Solution3590 {
    fun kthSmallest(par: IntArray, vals: IntArray, queries: Array<IntArray>): IntArray {
        val adj = mutableMapOf<Int, MutableList<Int>>()
        for ((u, p) in par.withIndex())
            if (p != -1)
                adj.getOrPut(p) { mutableListOf() }.add(u)

        val nodeToQs = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        for ((idx, q) in queries.withIndex()) {
            val (u, k) = q
            nodeToQs.getOrPut(u) { mutableListOf() }.add(Pair(idx, k))
        }

        val ans = IntArray(queries.size) { -1 }

        fun dfs(u: Int, pathXor: Int): TreeSet<Int> {
            val newXor = vals[u] xor pathXor
            var bigSet = TreeSet<Int>()
            bigSet.add(newXor)

            for (v in adj.getOrDefault(u, emptyList())) {
                val smallSet = dfs(v, newXor)
                if (smallSet.size > bigSet.size) {
                    smallSet.addAll(bigSet)
                    bigSet = smallSet
                } else {
                    bigSet.addAll(smallSet)
                }
            }

            for ((i, k) in nodeToQs.getOrDefault(u, emptyList()))
                if (k - 1 < bigSet.size)
                    ans[i] = bigSet.elementAt(k - 1)

            return bigSet
        }

        dfs(0, 0)
        return ans
    }
}
