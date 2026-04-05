package com.ypwang.medium

class Solution3889 {
    fun mirrorFrequency(s: String): Int {
        val c = s.groupBy { it }.mapValues { it.value.size }.toMutableMap()
        var rst = 0

        for (i in '0' until '5') {
            val mirror = '0' + (9 - (i - '0'))
            rst += Math.abs(c.getOrDefault(i, 0) - c.getOrDefault(mirror, 0))
        }

        for (i in 'a' .. 'm') {
            val mirror = 'a' + (25 - (i - 'a'))
            rst += Math.abs(c.getOrDefault(i, 0) - c.getOrDefault(mirror, 0))
        }

        return rst
    }
}
