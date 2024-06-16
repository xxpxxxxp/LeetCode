package com.ypwang.medium

class Solution3185 {
    fun countCompleteDayPairs(hours: IntArray): Long {
        val mod = IntArray(24)
        for (h in hours)
            mod[h % 24]++

        var rst = 0L
        rst += mod[0].toLong() * (mod[0] - 1) / 2
        rst += mod[12].toLong() * (mod[12] - 1) / 2
        for (i in 1 until 12)
            rst += mod[i].toLong() * mod[24-i]

        return rst
    }
}
