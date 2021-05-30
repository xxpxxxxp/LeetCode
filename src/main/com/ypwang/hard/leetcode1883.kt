package com.ypwang.hard

class Solution1883 {
    fun minSkips(dist: IntArray, speed: Int, hoursBefore: Int): Int {
        val max = Long.MAX_VALUE - speed
        val dp = Array(dist.size) { LongArray(dist.size) { max } }

        fun helper(i: Int, k: Int): Long =
            when {
                k < 0 -> max
                i < 0 -> 0L
                else -> {
                    if (dp[i][k] == max) {
                        dp[i][k] = dist[i] + minOf(
                            helper(i-1, k-1),
                            ((helper(i-1, k) + speed - 1) / speed) * speed
                        )
                    }

                    dp[i][k]
                }
            }

        if (dist.sum() > speed * hoursBefore)
            return -1

        return (dist.indices).firstOrNull { helper(dist.size-1, it) <= speed * hoursBefore } ?: -1
    }
}

fun main() {
    println(Solution1883().minSkips(intArrayOf(1,2,3,4,5), 100000, 1))
//    println(Solution1883().minSkips(intArrayOf(1,3,2), 4, 2))
}