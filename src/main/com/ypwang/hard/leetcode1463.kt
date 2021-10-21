package com.ypwang.hard

class Solution1463 {
    private val pos = listOf(-1, 0, 1)

    fun cherryPickup(grid: Array<IntArray>): Int {
        return grid.drop(1).fold(mapOf((0 to grid[0].lastIndex) to (grid[0].first() + grid[0].last()))) { m, row ->
            val next = mutableMapOf<Pair<Int, Int>, Int>()

            for ((xy, v) in m) {
                val (x, y) = xy
                for (xt in pos.map { x + it }) {
                    if (xt in row.indices) {
                        val vv = v + row[xt]
                        for (yt in pos.map { y + it }) {
                            if (yt in row.indices) {
                                val value = vv + if (xt != yt) row[yt] else 0
                                val p = minOf(xt, yt) to maxOf(xt, yt)
                                next[p] = maxOf(next.getOrDefault(p, 0), value)
                            }
                        }
                    }
                }
            }

            next
        }.values.maxOrNull()!!
    }
}

fun main() {
    println(Solution1463().cherryPickup(arrayOf(
            intArrayOf(4,1,5,7,1), intArrayOf(6,0,4,6,4), intArrayOf(0,9,6,3,5)
    )))
    println(Solution1463().cherryPickup(arrayOf(
            intArrayOf(3,1,1), intArrayOf(2,5,1), intArrayOf(1,5,5), intArrayOf(2,1,1)
    )))
}