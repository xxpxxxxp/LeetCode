package com.ypwang.medium

class Solution1937 {
    fun maxPoints(points: Array<IntArray>): Long =
        points.fold(LongArray(points[0].size)) { cur, arr ->
            val gain = LongArray(cur.size)
            var max = -1L
            for ((j, v) in cur.withIndex()) {
                max = maxOf(max-1, v)
                gain[j] = max
            }

            max = -1L
            for ((j, v) in cur.withIndex().reversed()) {
                max = maxOf(max-1, v)
                cur[j] = arr[j] + maxOf(gain[j], max)
            }

            cur
        }.maxOrNull()!!
}

fun main() {
    println(Solution1937().maxPoints(arrayOf(
        intArrayOf(1,2,3), intArrayOf(1,5,1), intArrayOf(3,1,1)
    )))
    println(Solution1937().maxPoints(arrayOf(
        intArrayOf(1,5), intArrayOf(2,3), intArrayOf(4,2)
    )))
}