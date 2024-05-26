package com.ypwang.medium

class Solution3111 {
    fun minRectanglesToCoverPoints(points: Array<IntArray>, w: Int): Int {
        val xs = points.map { it[0] }.sorted().toIntArray()
        var rst = 1
        var cur = xs.first()

        for (x in xs) {
            if (x - cur > w) {
                rst++
                cur = x
            }
        }

        return rst
    }
}