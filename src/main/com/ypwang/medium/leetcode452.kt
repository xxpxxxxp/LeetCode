package com.ypwang.medium

class Solution452 {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        val ps = points.map { Pair(it[0], it[1]) }.sortedBy { it.second }.toMutableList()

        var count = 0
        while (ps.isNotEmpty()) {
            count++

            val shoot = ps.first().second
            ps.removeIf { it.first <= shoot }
        }

        return count
    }
}

fun main() {
    println(Solution452().findMinArrowShots(
            arrayOf(
                    intArrayOf(10,16),
                    intArrayOf(2,8),
                    intArrayOf(1,6),
                    intArrayOf(7,12)
            )
    ))
}