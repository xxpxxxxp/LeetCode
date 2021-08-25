package com.ypwang.easy

class Solution1971 {
    fun validPath(n: Int, edges: Array<IntArray>, start: Int, end: Int): Boolean {
        val dsu = IntArray(n) { it }

        fun root(i: Int): Int {
            if (i != dsu[i]) dsu[i] = root(dsu[i])
            return dsu[i]
        }

        fun union(i: Int, j: Int) {
            dsu[root(i)] = root(j)
        }

        edges.forEach { (a, b) -> union(a, b) }

        return root(start) == root(end)
    }
}