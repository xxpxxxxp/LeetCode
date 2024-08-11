package com.ypwang.medium

class Solution3249 {
    fun countGoodNodes(edges: Array<IntArray>): Int {
        val conn = mutableMapOf<Int, MutableList<Int>>()
        for ((a, b) in edges) {
            conn.getOrPut(a) { mutableListOf() }.add(b)
            conn.getOrPut(b) { mutableListOf() }.add(a)
        }

        // good, sub node size
        fun helper(i: Int, parent: Int): Pair<Int, Int> {
            val subs = conn.getOrDefault(i, mutableListOf()).filter { it != parent }.map { helper(it, i) }
            if (subs.isEmpty())
                return 1 to 1
            val match = if (subs.map { it.second }.groupBy { it }.size == 1) 1 else 0
            return subs.map { it.first }.sum()!! + match to 1 + subs.map { it.second }.sum()!!
        }

        return helper(0, -1).first
    }
}
