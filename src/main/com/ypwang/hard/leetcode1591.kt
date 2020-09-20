package com.ypwang.hard

class Solution1591 {
    fun isPrintable(targetGrid: Array<IntArray>): Boolean {
        val pos = mutableMapOf<Int, IntArray>()

        val m = targetGrid.size
        val n = targetGrid[0].size
        for (i in 0 until m) {
            for (j in 0 until n) {
                pos.getOrPut(
                        targetGrid[i][j],
                        { intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MIN_VALUE, Int.MIN_VALUE) }
                )
                        .apply {
                            this[0] = minOf(this[0], i)
                            this[1] = minOf(this[1], j)
                            this[2] = maxOf(this[2], i)
                            this[3] = maxOf(this[3], j)
                        }
            }
        }

        fun testAndSet(v: Int): Boolean {
            val (x1, y1, x2, y2) = pos[v]!!

            for (i in x1..x2) {
                for (j in y1..y2) {
                    if (targetGrid[i][j] != 0 && targetGrid[i][j] != v)
                        return false
                }
            }

            for (i in x1..x2) {
                for (j in y1..y2) {
                    targetGrid[i][j] = 0
                }
            }

            return true
        }

        var colors = pos.keys.toSet()
        while (colors.isNotEmpty()) {
            val next = mutableSetOf<Int>()

            for (c in colors) {
                if (!testAndSet(c))
                    next.add(c)
            }

            if (next.size == colors.size)
                return false

            colors = next
        }

        return true
    }
}

fun main() {
    println(Solution1591().isPrintable(arrayOf(
            intArrayOf(1,2,1), intArrayOf(2,1,2), intArrayOf(1,2,1)
    )
    ))
}