package com.ypwang.medium

class Solution3809 {
    fun bestTower(towers: Array<IntArray>, center: IntArray, radius: Int): IntArray =
        towers.filter {
            Math.abs(it[0] - center[0]) + Math.abs(it[1] - center[1]) <= radius
        }.minWithOrNull(compareByDescending<IntArray> { it[2] }.thenBy { it[0] }.thenBy { it[1] })
            ?.take(2)?.toIntArray() ?: intArrayOf(-1, -1)
}
