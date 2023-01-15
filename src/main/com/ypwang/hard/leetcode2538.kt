package com.ypwang.hard

class Solution2538 {
    fun maxOutput(n: Int, edges: Array<IntArray>, price: IntArray): Long {
        val conn = Array(n) { mutableListOf<Int>() }
        for ((u, v) in edges) {
            conn[u].add(v)
            conn[v].add(u)
        }

        val max = mutableMapOf<Long, Long>()
        fun dfs(from: Int, cur: Int): Long {
            val id = (from + 1L) * (n + 1) + cur + 1
            if (id !in max) {
                var m = 0L
                for (next in conn[cur]) {
                    if (next != from)
                        m = maxOf(m, dfs(cur, next))
                }
                max[id] = price[cur] + m
            }
            return max[id]!!
        }

        return (0 until n).map { dfs(-1, it) - price[it] }.max()!!
    }
}

fun main() {
    println(Solution2538().maxOutput(
        100000,
        (0 until 100000-1).map { intArrayOf(it, it+1) }.toTypedArray(),
        IntArray(100000) {100000}
    ))
}