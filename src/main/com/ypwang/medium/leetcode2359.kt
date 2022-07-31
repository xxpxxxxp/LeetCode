package com.ypwang.medium

class Solution2359 {
    fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
        val m1 = IntArray(edges.size) { -1 }
        val m2 = IntArray(edges.size) { -1 }
        var rst = -1
        var min = Int.MAX_VALUE

        fun dfs(i: Int, m: IntArray) {
            var idx = i
            var dist = 0
            while (idx != -1 && m[idx] == -1) {
                m[idx] = dist++
                idx = edges[idx]
            }
        }

        dfs(node1, m1)
        dfs(node2, m2)
        for (i in edges.indices) {
            if (m1[i] >= 0 && m2[i] >= 0 && maxOf(m1[i], m2[i]) < min) {
                min = maxOf(m1[i], m2[i])
                rst = i
            }
        }

        return rst
    }
}

fun main() {
    println(Solution2359().closestMeetingNode(intArrayOf(2,2,3,-1), 0, 1))
}