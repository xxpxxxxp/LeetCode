package com.ypwang.medium

class Solution593 {
    private fun dist(p1: IntArray, p2: IntArray) =
            (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1])

    fun validSquare(p1: IntArray, p2: IntArray, p3: IntArray, p4: IntArray): Boolean {
        val t = listOf(
                dist(p1, p2) to Pair(p1, p2),
                dist(p2, p3) to Pair(p2, p3),
                dist(p1, p3) to Pair(p1, p3)
        ).sortedBy { it.first }

        if (t[2].first == 0 || t[0].first != t[1].first || t[0].first + t[1].first != t[2].first)
            return false

        val longSide = t[2].second
        val center = Pair(longSide.first[0] + longSide.second[0], longSide.first[1] + longSide.second[1])
        val xsum = t[0].second.first[0] + t[0].second.second[0] + t[1].second.first[0] + t[1].second.second[0] - center.first
        val ysum = t[0].second.first[1] + t[0].second.second[1] + t[1].second.first[1] + t[1].second.second[1] - center.second

        return xsum + 2 * p4[0] == 2 * center.first && ysum + 2 * p4[1] == 2 * center.second
    }
}

fun main() {
    println(Solution593().validSquare(intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(1, 0), intArrayOf(0, 1)))
}