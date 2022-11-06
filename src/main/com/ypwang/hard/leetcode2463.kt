package com.ypwang.hard

class Solution2463 {
    fun minimumTotalDistance(robot: List<Int>, factory: Array<IntArray>): Long {
        val cache = Array(robot.size) { Array(factory.size){ LongArray(robot.size){-1} } }

        val rb = robot.sorted().toIntArray()
        factory.sortBy { it[0] }

        fun dp(i: Int, j: Int, k: Int): Long {
            if (i == rb.size)
                return 0L
            if (j == factory.size)
                return Long.MAX_VALUE

            if (cache[i][j][k] >= 0)
                return cache[i][j][k]

            var handle = Long.MAX_VALUE
            if (factory[j][1] > k) {
                handle = dp(i+1, j, k+1)
                if (handle < Long.MAX_VALUE)
                    handle += Math.abs(rb[i] - factory[j][0])
            }
            cache[i][j][k] = minOf(dp(i, j+1, 0), handle)
            return cache[i][j][k]
        }

        return dp(0, 0, 0)
    }
}

fun main() {
    println(Solution2463().minimumTotalDistance(listOf(0,4,6), arrayOf(
        intArrayOf(2,2), intArrayOf(6,2)
    )))
}