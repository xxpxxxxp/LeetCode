package com.ypwang.medium

class Solution539 {
    fun findMinDifference(timePoints: List<String>): Int {
        val tmp = timePoints.map {
            it.take(2).toInt() * 60 + it.takeLast(2).toInt()
        }.sorted()

        return Math.min((0 until tmp.lastIndex).map { tmp[it+1] - tmp[it] }.min()!!, 1440 + tmp.first() - tmp.last())
    }
}