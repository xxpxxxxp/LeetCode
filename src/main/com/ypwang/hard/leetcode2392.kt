package com.ypwang.hard

import java.util.*

class Solution2392 {
    fun buildMatrix(k: Int, rowConditions: Array<IntArray>, colConditions: Array<IntArray>): Array<IntArray> {
        val order1 = generateTopologicalSort(rowConditions, k)
        val order2 = generateTopologicalSort(colConditions, k)
        if (order1.size < k || order2.size < k)
            return Array(0) { IntArray(0) }
        val m = mutableMapOf<Int, Int>()
        for (i in 0 until k)
            m[order2[i]] = i

        val ans = Array(k) { IntArray(k) }
        for (i in 0 until k)
            ans[i][m[order1[i]]!!] = order1[i]

        return ans
    }

    private fun generateTopologicalSort(A: Array<IntArray>, k: Int): List<Int> {
        val deg = IntArray(k)
        val order = mutableListOf<Int>()
        val graph = Array(k) { mutableListOf<Int>() }

        val q: Queue<Int> = LinkedList()
        for ((a, b) in A) {
            graph[a - 1].add(b - 1)
            deg[b - 1]++
        }
        for (i in 0 until k)
            if (deg[i] == 0) q.add(i)
        while (!q.isEmpty()) {
            val x = q.poll()
            order.add(x + 1)
            for (y in graph[x])
                if (--deg[y] == 0) q.add(y)
        }
        return order
    }
}