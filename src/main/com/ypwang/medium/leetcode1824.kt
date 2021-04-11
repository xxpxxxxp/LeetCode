package com.ypwang.medium

class Solution1824 {
    fun minSideJumps(obstacles: IntArray): Int =
        obstacles.drop(1).fold(intArrayOf(1,0,1)) { p, o ->
            val min = p.withIndex().filter { it.index != o - 1 }.minBy{ it.value }!!.index
            val v = p[min]
            for (i in 0..2) {
                if (i != min) {
                    p[i] = minOf(p[i], v + 1)
                }
            }
            if (o > 0)
                p[o-1] = Int.MAX_VALUE

            p
        }.min()!!
}

fun main() {
    println(Solution1824().minSideJumps(intArrayOf(0,1,2,3,0)))
    println(Solution1824().minSideJumps(intArrayOf(0,1,1,3,3,0)))
    println(Solution1824().minSideJumps(intArrayOf(0,2,1,0,3,0)))
}