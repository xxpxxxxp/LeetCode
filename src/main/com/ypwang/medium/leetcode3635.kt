package com.ypwang.medium

class Solution3635 {
    fun earliestFinishTime(landStartTime: IntArray, landDuration: IntArray, waterStartTime: IntArray, waterDuration: IntArray): Int {
        var ans = Int.Companion.MAX_VALUE

        val landEnd = landStartTime.zip(landDuration).minOf { it.first + it.second }
        for (i in 0 until waterStartTime.size)
            ans = minOf(ans, waterDuration[i] + maxOf(landEnd, waterStartTime[i]))

        val waterEnd = waterStartTime.zip(waterDuration).minOf { it.first + it.second }
        for (i in 0 until landStartTime.size)
            ans = minOf(ans, landDuration[i] + maxOf(waterEnd, landStartTime[i]))

        return ans
    }
}

fun main() {
    println(Solution3635().earliestFinishTime(
        intArrayOf(82,14),
        intArrayOf(42,30),
        intArrayOf(6,54),
        intArrayOf(91,71)
    ))
}