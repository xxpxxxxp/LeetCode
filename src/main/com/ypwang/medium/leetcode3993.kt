package com.ypwang.medium

class Solution3993 {
    fun maximumValue(n: Int, s: Int, m: Int): Long {
        if (n == 1)
            return s.toLong()

        val increase = n / 2
        val decrease = increase - 1

        return s + increase.toLong() * m - decrease
    }
}
