package com.ypwang.hard

import java.util.LinkedList
import java.util.Queue

class Solution2603 {
    fun collectTheCoins(coins: IntArray, edges: Array<IntArray>): Int {
        val n = coins.size
        val g = Array(n) { mutableSetOf<Int>() }
        val degree = IntArray(n)

        for ((a, b) in edges) {
            g[a].add(b)
            g[b].add(a)
            degree[a]++
            degree[b]++
        }

        val q: Queue<Int> = LinkedList(coins.withIndex().filter { degree[it.index] == 1 && it.value == 0 }.map { it.index })
        while (q.isNotEmpty()) {
            val i = q.poll()
            for (next in g[i]) {
                if (--degree[next] == 1 && coins[next] == 0) {
                    q.offer(next)
                }
                g[next].remove(i)
            }
            g[i].clear()
            degree[i] = n
        }

        q.addAll(coins.indices.filter { degree[it] == 1 })
        for (t in 0 until 2) {
            val len = q.size
            for (i in len-1 downTo 0) {
                val cur = q.poll()
                for (next in g[cur]) {
                    if (--degree[next] == 1)
                        q.offer(next)
                    g[next].remove(cur)
                }
                g[cur].clear()
                degree[cur] = n
            }
        }

        return maxOf(0, (g.count { it.isNotEmpty() } - 1) * 2)
    }
}
