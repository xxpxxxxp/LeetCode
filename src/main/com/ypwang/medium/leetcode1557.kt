package com.ypwang.medium

class Solution1557 {
    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
        val t = BooleanArray(n)
        for ((from, to) in edges) {
            t[to] = true
        }

        return t.withIndex().filter { !it.value }.map { it.index }
    }
}