package com.ypwang.medium

class Solution3281 {
    fun maxPossibleScore(start: IntArray, d: Int): Int {
        start.sort()
        var l = 0L
        var r = 2000000000L
        val n = start.size
        while (l <= r) {
            val m = (l + r) / 2
            var prev = start[0].toLong()
            var can = true
            for (i in 1 until n) {
                val next = prev + m
                if (next > start[i] + d) {
                    can = false
                    break
                } else
                    prev = maxOf(next, start[i].toLong())
            }
            if (can)
                l = m + 1 else r = m - 1
        }
        return (l - 1).toInt()
    }
}
