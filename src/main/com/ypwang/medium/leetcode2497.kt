package com.ypwang.medium

class Solution2497 {
    fun maxStarSum(vals: IntArray, edges: Array<IntArray>, k: Int): Int {
        val conn = Array(vals.size) { mutableListOf<Int>() }
        for ((a, b) in edges) {
            conn[a].add(vals[b])
            conn[b].add(vals[a])
        }

        return conn.withIndex().map { (i, ns) ->
            val usable = ns.filter { it > 0 }

            vals[i] +
            if (usable.size <= k) usable.sum()
            else usable.sortedDescending().take(k).sum()
        }.max()
    }
}

fun main() {
    println(Solution2497().maxStarSum(intArrayOf(1, -8, 0), arrayOf(intArrayOf(1,0), intArrayOf(2,1)), 2))
}