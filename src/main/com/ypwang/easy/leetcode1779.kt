package com.ypwang.easy

class Solution1779 {
    fun nearestValidPoint(x: Int, y: Int, points: Array<IntArray>): Int =
        points.withIndex()
            .filter { (_, pos) -> pos[0] == x || pos[1] == y }
            .map { (idx, pos) -> idx to Math.abs(pos[0] - x) + Math.abs(pos[1] - y) }
            .minBy { it.second }
            ?.first
            ?: -1
}