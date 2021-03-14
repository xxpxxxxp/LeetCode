package com.ypwang.medium

class Solution1791 {
    fun findCenter(edges: Array<IntArray>): Int {
        val count = IntArray(edges.size + 1)
        for ((a, b) in edges) {
            count[a-1]++
            count[b-1]++
        }

        return count.withIndex().single { it.value > 1 }.index + 1
    }
}