package com.ypwang.hard

class Solution1473 {
    fun minCost(houses: IntArray, cost: Array<IntArray>, m: Int, n: Int, target: Int): Int =
            houses.withIndex().fold(mapOf((0 to 0) to 0)) { dp, (i, c) ->
                val next = mutableMapOf<Pair<Int, Int>, Int>()
                val colors = if (c == 0) 1..n else listOf(c)
                for (color in colors) {
                    for ((p, spend) in dp) {
                        val (preColor, blocks) = p
                        val nBlocks = blocks + if (preColor == color) 0 else 1
                        if (nBlocks > target) continue
                        val key = color to nBlocks
                        next[key] = minOf(
                                next.getOrDefault(key, Int.MAX_VALUE),
                                spend + if (c == 0) cost[i][color - 1] else 0
                        )
                    }
                }

                next
            }.filter { it.key.second == target }.values.min() ?: -1
}

fun main() {
    val t = System.currentTimeMillis()
    println(Solution1473().minCost(
            intArrayOf(0, 0, 6, 0, 8, 0, 0, 7, 10, 0, 0, 0, 0, 4, 0, 0, 0, 11, 1, 0, 0, 0, 0),
            arrayOf(intArrayOf(38, 49, 27, 44, 2, 28, 14, 13, 39, 7, 22), intArrayOf(49, 19, 32, 38, 40, 15, 13, 19, 26, 30, 31), intArrayOf(43, 45, 8, 10, 26, 21, 26, 26, 35, 22, 46), intArrayOf(11, 2, 50, 18, 47, 38, 41, 47, 41, 9, 49), intArrayOf(27, 6, 29, 32, 39, 45, 47, 18, 2, 38, 21), intArrayOf(14, 36, 33, 16, 11, 10, 25, 41, 32, 47, 36), intArrayOf(38, 5, 3, 23, 15, 42, 49, 31, 29, 24, 39), intArrayOf(37, 50, 46, 48, 43, 1, 38, 17, 45, 30, 39), intArrayOf(37, 6, 37, 46, 20, 28, 18, 1, 24, 5, 21), intArrayOf(18, 10, 5, 2, 23, 40, 47, 26, 41, 24, 22), intArrayOf(1, 41, 43, 17, 3, 48, 31, 1, 21, 30, 47), intArrayOf(4, 30, 1, 28, 10, 23, 25, 50, 10, 43, 1), intArrayOf(39, 46, 10, 49, 33, 29, 23, 38, 14, 12, 15), intArrayOf(27, 5, 33, 50, 18, 15, 5, 6, 15, 27, 15), intArrayOf(18, 29, 35, 32, 1, 12, 49, 43, 15, 24, 48), intArrayOf(9, 29, 45, 26, 48, 45, 17, 16, 16, 3, 49), intArrayOf(5, 33, 13, 12, 39, 49, 46, 46, 11, 37, 17), intArrayOf(8, 7, 10, 19, 31, 28, 48, 37, 14, 47, 7), intArrayOf(47, 12, 3, 4, 47, 9, 39, 11, 47, 38, 14), intArrayOf(44, 17, 31, 43, 6, 30, 18, 43, 16, 29, 27), intArrayOf(42, 4, 28, 36, 50, 17, 43, 21, 29, 6, 33), intArrayOf(36, 20, 49, 15, 32, 45, 5, 6, 9, 29, 16), intArrayOf(49, 26, 48, 13, 42, 11, 23, 9, 42, 24, 6)),
            23,
            11,
            23
    ))
    println(System.currentTimeMillis() - t)
}