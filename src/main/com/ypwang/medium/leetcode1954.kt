package com.ypwang.medium

class Solution1954 {
    fun minimumPerimeter(x: Long): Long {
        var l = 1L
        var r = 100000L
        while (l < r) {
            val m = (l + r) / 2
            if (m * m * m * 4 + m * m * 6 + m * 2 >= x)
                r = m
            else
                l = m + 1
        }

        return 8 * l
    }
}